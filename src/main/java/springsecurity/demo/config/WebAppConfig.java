package springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "springsecurity.demo")
@PropertySource("classpath:application.properties") // properties file source located at resources (maven default)
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env; // variable that holds the properties

	// setting up logger
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// bean for security data source if jdbc authentication use
	@Bean
	public DataSource SecurityDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// get properties from file
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		// logger
		logger.info("JDBC URL ==> " + env.getProperty("jdbc.url"));
		logger.info("JDBC User ==> " + env.getProperty("jdbc.user"));
		return dataSource;
	}

}