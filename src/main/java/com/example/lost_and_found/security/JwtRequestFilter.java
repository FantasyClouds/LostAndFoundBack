package com.example.lost_and_found.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    // 添加日志记录
    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    // 添加属性绑定注解
    @Value("${security.jwt.enabled:true}") // 默认值防止未配置时报错
    private boolean jwtEnabled;

    @Value("${security.jwt.mock-user:tester}")
    private String mockUsername;

    // 改为构造器注入（Spring 4.3+ 单构造器可省略 @Autowired）
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(UserDetailsService userDetailsService,
                            JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        // ================ 新增开发模式逻辑 ================
        if (!jwtEnabled) {
            // 创建模拟用户（带管理员权限）
            UserDetails mockUser = org.springframework.security.core.userdetails.User.builder()
                    .username(mockUsername)
                    .password("")
                    .authorities("ROLE_ADMIN") // 根据需要调整权限
                    .build();

            // 注入安全上下文
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(mockUser, null, mockUser.getAuthorities())
            );

            chain.doFilter(request, response);
            return; // 跳过后续JWT验证
        }


        final String requestTokenHeader = request.getHeader("Authorization");

        // 优化空值判断逻辑
        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = requestTokenHeader.substring(7);
        try {
            String username = jwtTokenUtil.extractUsername(jwtToken);

            // 添加空用户名防御
            if (username == null || SecurityContextHolder.getContext().getAuthentication() != null) {
                chain.doFilter(request, response);
                return;
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 强化验证条件（同时检查用户状态）
            if (jwtTokenUtil.validateToken(jwtToken, userDetails) && userDetails.isEnabled()) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // 无状态场景下可省略 Details 设置（按需保留）
                if (this.isSessionCreationEnabled(request)) {
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                }

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            // 明确异常处理（记录日志并清除上下文）
            logger.error("JWT 认证失败: {}", ex.getMessage());
            SecurityContextHolder.clearContext();

            // 直接返回401响应（或抛出 AuthenticationException 由入口点处理）
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无效的认证令牌");
            return;  // 终止过滤器链
        }

        chain.doFilter(request, response);
    }

    // 判断是否需要创建会话（适配无状态场景）
    private boolean isSessionCreationEnabled(HttpServletRequest request) {
        return request.getSession(false) != null;
    }
}
