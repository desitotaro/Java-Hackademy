package it.aulab.springbootcontroller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        //Bcript trasforma la psw in una 'firma'(digest), è un algoritmo di encoding
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public InMemoryUserDetailsManager createUserDetails() {
        
        String password =  passwordEncoder().encode("password");
        System.out.println(password);
        //Classe user con psw password e user user
        UserBuilder userBuilder = User.withUsername("user")
        .password(password)
        .roles("USER");
        //Admin con password admin e utente admin
        UserBuilder adminBuilder = User.withUsername("admin")
        .password(passwordEncoder().encode("admin"))
        .roles("USER", "ADMIN");
        
        return new InMemoryUserDetailsManager(userBuilder.build(), adminBuilder.build());
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .requestMatchers("/login", "/logout", "/api/**").permitAll()
        // a questo path può accedere solo l'admin, quindi solo un utente con role ADMIN
        .requestMatchers("/authors/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and().formLogin()
        .loginPage("/login")
        //specifico la login, gestita come una post
        .loginProcessingUrl("/login")
        //gestisco le redirect always true, cioè che lo deve fare sempre su quel path
        .defaultSuccessUrl("/", true)
        //gestisco il processo di logout, gestita come una post
        .and().logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .and().csrf().ignoringRequestMatchers("/api/**")
        .and().headers()
        .xssProtection()
        .and()
        .contentSecurityPolicy("style-src 'self' maxcdn.bootstrapcdn.com getbootstrap.com *.googleapis.com cdn.jsdelivr.net cdnjs.cloudflare.com; script-src 'self' cdn.jsdelivr.net");
        return http.build();
    }
}

