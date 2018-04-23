package springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("test").password("test").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("mary").password("secret123").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().
		antMatchers("/").hasRole("EMPLOYEE").
		antMatchers("/admin/**").hasRole("ADMIN").
		antMatchers("/manager/**").hasRole("MANAGER").
		and().formLogin()
				.loginPage("/customlogin").loginProcessingUrl("/login").permitAll();
				
				
//				defaultSuccessUrl("/adminhome")
//				.usernameParameter("username").passwordParameter("password").permitAll();

		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/customlogin")
		// .loginProcessingUrl("/login").defaultSuccessUrl("/").permitAll();

		// super.configure(http);
	}
}
