package com.dti.projeto.config;

import com.dti.projeto.LembretesApplication;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Configuration
public class SecurityConfig {
    public class ServletInitializer extends SpringBootServletInitializer {
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(LembretesApplication.class);
        }
        @Component
        public class CORSFilter implements Filter {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
            }
            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, auth-token" );
                response.setHeader("Access-Control-Expose-Headers", "Location");
                filterChain.doFilter(servletRequest, servletResponse);
            }
            @Override
            public void destroy() {
            }
        }
    }

}
