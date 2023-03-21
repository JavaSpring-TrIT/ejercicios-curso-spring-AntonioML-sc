package com.cursos.inicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	//definición de políticas de seguridad	
	@Bean
	SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests(requests -> requests
				.requestMatchers("/register").hasRole("ADMIN")
				.requestMatchers("/updateDuration","/delete/**").hasAnyRole("ADMIN","OPERADOR")
				.anyRequest().authenticated()
			)
			.httpBasic(withDefaults());

		return http.build();
	}

    //definición roles y usuarios
    @SuppressWarnings("deprecation")
	@Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("user1")
                        .roles("INVITADO")
                        .build();
        
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("user2")
                        .password("user2")
                        .roles("OPERADOR")
                        .build();
        
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                        .username("user3")
                        .password("user3")
                        .roles("ADMIN")
                        .build();
        
        UserDetails user4 =
                User.withDefaultPasswordEncoder()
                        .username("user4")
                        .password("user4")
                        .roles("ADMIN","OPERADOR")
                        .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }
}
