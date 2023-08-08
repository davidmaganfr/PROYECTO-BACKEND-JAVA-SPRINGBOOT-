package com.springrenovables.springrenovables_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("david")
                .password("1111")
                .roles("USER")
                .passwordEncoder(pw -> passwordEncoder.encode(pw))
                .build();
        UserDetails user2 = User.withUsername("abc")
                .password("abc")
                .authorities("USER2")
                .passwordEncoder(pw -> passwordEncoder.encode(pw))
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/mediciones/index", "/mediciones/find").permitAll()
                .anyRequest().hasRole("USER"))
                .formLogin(formlogin -> formlogin.permitAll())
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}
