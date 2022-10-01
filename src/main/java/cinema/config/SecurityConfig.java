package cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/inject").permitAll()
                .antMatchers(HttpMethod.GET, "/cinema-halls")
                .hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/cinema-halls")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/movies")
                .hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/movies")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/movie-sessions/available")
                .hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/movie-sessions")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/movie-sessions/{id}")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/{id}")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/orders")
                .hasAnyAuthority("USER")
                .antMatchers(HttpMethod.POST, "/orders/complete")
                .hasAnyAuthority("USER")
                .antMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions")
                .hasAnyAuthority("USER")
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user")
                .hasAnyAuthority("USER")
                .antMatchers(HttpMethod.GET, "/users/by-email")
                .hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
