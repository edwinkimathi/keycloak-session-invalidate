package com.example.config.initializer;

import com.example.config.SecurityConfig;
import com.example.config.SessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class RedisHttpSessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {

    public RedisHttpSessionApplicationInitializer() {
        super(SessionConfig.class, SecurityConfig.class);
    }
}
