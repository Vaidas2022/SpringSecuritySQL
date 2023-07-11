package lt.codeacademy.javau5.securitysql.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests(authorize -> authorize
        				.anyRequest().permitAll()
        	)
        	
        	.formLogin(withDefaults()
        	)
        
        	.logout(logout -> logout
        			.logoutUrl("/anonymous")
        			.deleteCookies("JSESSIONID")
        	)
        			
        ;
	    return http.build();
	}
	
	@Bean 
	PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
}
