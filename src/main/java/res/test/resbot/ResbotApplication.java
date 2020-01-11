package res.test.resbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@PropertySource(value = "application.properties")
public class ResbotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();

		SpringApplication.run(ResbotApplication.class, args);
	}

}
