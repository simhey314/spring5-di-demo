package guru.springframework.config;

import guru.services.GreetingRepository;
import guru.services.GreetingService;
import guru.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfig {

	@Bean
	public GreetingServiceFactory greetingServiceFactory(final GreetingRepository greetingRepository) {
		return new GreetingServiceFactory(greetingRepository);
	}

	@Bean
	@Primary
	@Profile({"en", "default"})
	public GreetingService primaGreetingService(final GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("en");
	}

	@Bean
	@Primary
	@Profile({"es"})
	public GreetingService primaSpanishGreetingService(final GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("es");
	}

	@Bean
	@Primary
	@Profile({"de"})
	public GreetingService primaGermanGreetingService(final GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("de");
	}
}
