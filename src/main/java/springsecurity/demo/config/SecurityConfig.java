package springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource myDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(myDataSource);

		// in memeory authentication
		/*
		 * auth.inMemoryAuthentication().withUser("test").password("test").roles(
		 * "EMPLOYEE");
		 * auth.inMemoryAuthentication().withUser("m").password("m").roles("MANAGER");
		 * auth.inMemoryAuthentication().withUser("admin").password("admin").roles(
		 * "ADMIN","EMPLOYEE");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").
				antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/manager/**").hasRole("MANAGER").
				and().formLogin().loginPage("/customlogin")
				.loginProcessingUrl("/login").permitAll().
				and().logout().permitAll().
				and().exceptionHandling()
				.accessDeniedPage("/access-failed");

		// defaultSuccessUrl("/adminhome")
		// .usernameParameter("username").passwordParameter("password").permitAll();

		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/customlogin")
		// .loginProcessingUrl("/login").defaultSuccessUrl("/").permitAll();

		// super.configure(http);
	}
}
