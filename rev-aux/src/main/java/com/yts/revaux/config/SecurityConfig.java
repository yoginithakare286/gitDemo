package com.yts.revaux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS n
            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers("/auth/login", "/buyerlogin").permitAll() // Allow login endpoints
            	    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow preflight requests
            	    .requestMatchers("/*.js", "/*.txt", "/*.json", "/*.map", "/*.css").permitAll()
            	    .requestMatchers("/*.ico", "/*.png", "/*.svg", "/*.webapp").permitAll()
            	    .requestMatchers("/assets/**").permitAll()
            	    .requestMatchers("/ntQuoteList").permitAll() // Allow access to this endpoint
            	    .requestMatchers("/ntQuoteListMainPage").permitAll()
            	    .requestMatchers("/ntQuoteDetailedScreen").permitAll()
            	    .requestMatchers("/YT_UI_WORK/**").permitAll()
            	    .requestMatchers("/api/ntQuotes/**").permitAll()
            	    .requestMatchers("/api/nt-quote-customer-input-output/getCalculationInputOutputData/**").permitAll()
            	    .requestMatchers("/api/nt-quote-customer-input-output/saveCalculationInputOutputData/**").permitAll()
            	    .requestMatchers("/api/quoteLabourRate/getQuoteLabourRateData").permitAll()
            	    .requestMatchers("/api/quoteScrapRate/getQuoteScrapRateData").permitAll()
            	    .requestMatchers("/api/quoteMachineEfficiency/getMachineEfficiencyData").permitAll()  
            	    
            	    .requestMatchers("/api/nt-quote-customer-projects/**").permitAll() 
            	    .requestMatchers("/api/nt-quote-customer-projects/fetchCustomerInfoData/**").permitAll()
            	    .requestMatchers("/api/nt-quote-customer-projects/updateExistingCustomer/**").permitAll()
            	    .requestMatchers("/api/nt-quote-component-details/featchComponentDetails/**").permitAll()
            	    .requestMatchers("/api/nt-quote-project-considerations/**").permitAll()
            	    .requestMatchers("/api/nt-quote-contract-review-informations/**").permitAll()
            	    
            	    .requestMatchers("/api/nt-quote-project-timing/**").permitAll()
            	    .requestMatchers("/api/nt-quote-project-timing/update/**").permitAll()
            	    .requestMatchers("/api/nt-quote-component-details/update/**").permitAll()
            	  
            	    .requestMatchers("/api/ntQuotes/checkMoldMannualFileExists").permitAll()
                    .requestMatchers("/api/ntQuotes/overwriteMoldManualAttachment").permitAll()
                    .requestMatchers("/api/ntQuotes/uploadMoldManualFile").permitAll()
                    .requestMatchers("/api/ntQuotes/downloadMoldManualFile/**").permitAll()
                    .requestMatchers("/api/ntQuotes/deleteMoldManualFile").permitAll()
                    .requestMatchers("/api/ntQuotes/getQuoteById/**").permitAll()
            	    .requestMatchers("/admin").authenticated()
            	    .anyRequest().authenticated()
            	)
           
            .exceptionHandling(exception -> exception
                    .authenticationEntryPoint((request, response, authException) -> {
                        response.sendRedirect(request.getContextPath() + "/buyerlogin"); // Redirect on unauthorized access
                    })
                )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8080")); // Adjust for frontend
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
