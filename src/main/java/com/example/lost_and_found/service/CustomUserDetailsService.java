package com.example.lost_and_found.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // 模拟数据库中的用户（正式项目需替换为数据库查询）
    private static final String MOCK_ACCOUNT = "user@example.com";
    private static final String MOCK_ENCRYPTED_PASSWORD = "{bcrypt}$2a$10$dXJ3SW6G7P50lGHRfVhNx.O2oES4Qb7UdII7KJQem6VtflnRSQw/W";
    private static final String MOCK_ROLE = "USER";

    @Override
    public UserDetails loadUserByUsername(String account)
            throws UsernameNotFoundException {

        // 根据 account（可能是邮箱/手机号）查询用户
        if (!MOCK_ACCOUNT.equals(account)) {
            throw new UsernameNotFoundException("账号不存在: " + account);
        }

        return User.builder()
                .username(account) // 使用 account 作为唯一标识
                .password(MOCK_ENCRYPTED_PASSWORD) // 加密后的密码
                .roles(MOCK_ROLE)
                .build();
    }
}
