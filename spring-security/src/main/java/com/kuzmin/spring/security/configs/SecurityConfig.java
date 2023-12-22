package com.kuzmin.spring.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity

public class SecurityConfig {

    //здесь мы настраиваем куда у пользователя есть доступ, куда у него нет доступа, где требуются роли,
    // какие то права доступа, как он должен вбивать логин и пароль, что должно происходить когда он выходит, все эти настройки прописываются здесь
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/authenticated/**").authenticated()
                //and разделитель говорим что хотим еще что то настроить
                .and()
                //стандартная форма логина
               // .httpBasic()
                //кастомная форма, ее нужно настраивать!!
                .formLogin()
                .and()
                //говорим что после выхода перенаправлялось не на странишку логина а на корень приложения
                .logout().logoutSuccessUrl("/");
        return http.build();
    }
}

