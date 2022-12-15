package mx.rafex.tutum.school.rest.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableWebMvc
class WebSecurityConfig implements WebMvcConfigurer {

    private static final Logger LOG = Logger
            .getLogger(WebSecurityConfig.class.getName());

    private static final String[] AUTH_WHITELIST = { "/", "/**", "/api/**" };

//    @Autowired
//    private JWTAuthorizationFilter jwtAuthorizationFilter;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        LOGGER.info("Configure!!!");
//
//        http = http.cors().and().csrf().disable();
//
//        http = http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
//
//        http = http.exceptionHandling()
//                .authenticationEntryPoint(
//                        new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and();
//        http.authorizeRequests().antMatchers("/**").permitAll()
//                .antMatchers("/public/**").permitAll().anyRequest()
//                .authenticated();
//
//        http.addFilterBefore(jwtAuthorizationFilter,
//                UsernamePasswordAuthenticationFilter.class);
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(AUTH_WHITELIST);
//    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)
            throws Exception {

        http.cors().and().csrf().disable();

        return http.build();
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
