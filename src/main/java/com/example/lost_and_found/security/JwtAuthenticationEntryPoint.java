package com.example.lost_and_found.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // 添加 JSON 序列化工具
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // 构建结构化错误响应
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        errorDetails.put("error", "Unauthorized");
        errorDetails.put("message", getMessageForClient(authException));
        errorDetails.put("path", request.getRequestURI());

        // 设置响应头
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        // 禁止缓存敏感信息
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // 写入 JSON 响应
        objectMapper.writeValue(response.getWriter(), errorDetails);
    }

    private String getMessageForClient(AuthenticationException ex) {
        // 根据异常类型细化错误信息
        String defaultMsg = "需要有效的认证令牌";
        if (ex.getCause() instanceof ExpiredJwtException) {
            return "令牌已过期，请重新登录";
        }
        if (ex.getCause() instanceof SignatureException) {
            return "无效的令牌签名";
        }
        return defaultMsg;
    }
}
