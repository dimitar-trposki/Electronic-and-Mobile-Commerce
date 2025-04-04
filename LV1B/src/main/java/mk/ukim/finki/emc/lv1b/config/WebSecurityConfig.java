//package mk.ukim.finki.emc.lv1b.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class WebSecurityConfig {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers
//                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
//                )
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html")
//                        .permitAll()
//                        .requestMatchers("/", "/api/books", "/api/books/add", "/api/books/delete/*", "/api/books/edit/*", "/api/books/rent/*")
//                        .hasRole("LIBRARIAN")
//                        .anyRequest().hasRole("ADMIN")
//                )
//                .formLogin((form) -> form
//                        .permitAll()
//                        .defaultSuccessUrl("/api/books", true)
//                )
//                .logout((logout) -> logout
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/api/books")
//                );
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails librarian = User.builder()
//                .username("librarian")
//                .password(passwordEncoder.encode("librarian"))
//                .roles("LIBRARIAN")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(librarian, admin);
//    }
//}