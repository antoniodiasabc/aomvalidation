package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class Application extends WebMvcConfigurerAdapter {

	@Autowired
	PropertyConfiguration propertyConfiguration;

	private static String[] args;
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		Application.args = args;
		Application.context = SpringApplication.run(Application.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new DynamicArgumentResolver(propertyConfiguration));
	}

	public static void restart() {
		// close previous context
		context.close();

		// and build new one
		Application.context = SpringApplication.run(Application.class, args);
	}

	public void refreshCtx() throws Exception {
		context.refresh();
	}

}
