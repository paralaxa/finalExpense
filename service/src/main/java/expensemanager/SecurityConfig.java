package expensemanager;

import expensemanager.user.UserCreateDto;
import expensemanager.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Value("${user.admin.pswd}")
    private String adminPswd;
    @Value("${user.admin.username}")
    private String adminUsername;
    @Autowired
    private DataSource dataSource;
    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);


    @PostConstruct
    public void createAdmin() {
        UserDetails admin = userService.loadUserByUsername(adminUsername);
        if (admin == null) {
            UserCreateDto userCreateDto = new UserCreateDto();
            userCreateDto.setUsername(adminUsername);
            userCreateDto.setPassword(adminPswd);
            userService.create(userCreateDto);
        }
    }
//in case we want just to customize authentication with set of queries (do not need to explixitly define userdetailservice or authmanager)
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled from Users " +
//                                "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities " +
//                                "where username=?")
//                .passwordEncoder(passwordEncoder());
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                headers().frameOptions().disable() //kvoli h2 console
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/api-docs/**").authenticated()
                .antMatchers("/v1/user/**").hasRole("ADMIN")
                .anyRequest().hasRole("USER");
    }


}
