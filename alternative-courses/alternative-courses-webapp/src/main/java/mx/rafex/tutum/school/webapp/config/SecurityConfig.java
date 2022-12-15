package mx.rafex.tutum.school.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String ZUL_FILES = "/web/**/*.zul";

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        final var users = User.withDefaultPasswordEncoder();
        final var manager = new InMemoryUserDetailsManager();
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
        http.cors().and().csrf().disable() // can be disabled safely; ZK unique
                                           // desktop ID
                // generation prevents Cross-Site Request Forgery
                // attacks
                // application specific
                .authorizeRequests().antMatchers(ZUL_FILES).denyAll() // block
                                                                      // direct
                                                                      // access
                                                                      // to zul
                                                                      // under
                                                                      // class
                                                                      // path
                                                                      // web
                                                                      // resource
                                                                      // folder
                .mvcMatchers("/login", "/logout").permitAll()
                .mvcMatchers("/", "/list", "/form").hasRole("USER")
                .mvcMatchers("/admin").hasRole("ADMIN").and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/list").and().logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login");

        return http.build();
    }

}