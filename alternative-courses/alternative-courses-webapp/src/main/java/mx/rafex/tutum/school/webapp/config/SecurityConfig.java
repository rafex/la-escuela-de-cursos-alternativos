package mx.rafex.tutum.school.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static String currentUser = System.getProperty("user.name");
    private static BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(16);
    private static String password = bcrypt.encode("password");

//    @Override
//    protected void configure(
//            AuthenticationManagerBuilder authenticationManagerBuilder)
//            throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("user")
//                .password(password).roles("USER").and().withUser(currentUser)
//                .password(password).roles("USER", "ADMIN").and()
//                .passwordEncoder(bcrypt);
//    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password")
                .roles("USER").build());
        manager.createUser(users.username("admin").password("password")
                .roles("USER", "ADMIN").build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)
            throws Exception {

        // zk specific -- maybe disable CSRF set by default via
        // auto-configuration? --
        http.csrf().disable() // can be disabled safely; ZK unique desktop ID
                              // generation prevents Cross-Site Request Forgery
                              // attacks

                // application specific
                .authorizeRequests()
                .antMatchers("/web/**/js/**", "/web/**/zul/css/**",
                        "/web/**/img/**")
                .permitAll()

                .mvcMatchers("/", "/login", "/logout").permitAll()
                .mvcMatchers("/secure").hasRole("USER").mvcMatchers("/admin")
                .hasRole("ADMIN")

                .antMatchers("/web/**/**.zul").denyAll() // calling a
                                                         // zul-page
                                                         // directly is not
                                                         // allowed --
                                                         // should we put
                                                         // this in the
                                                         // auto-configuration
                                                         // to? --

                .and().formLogin().loginPage("/login").defaultSuccessUrl("/")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

        return http.build();
    }

}