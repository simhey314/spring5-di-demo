package guru.services;

public class GreetingServiceFactory {

	private GreetingRepository greetingRepository;

	public GreetingServiceFactory(final GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	public GreetingService createGreetingService(final String lang) {
		GreetingService result = null;
		switch (lang) {
			case "en":
				result = new PrimaryGreetingService(greetingRepository);
				break;
			case "es":
				result = new PrimarySpanishGreetingService(greetingRepository);
				break;
			case "de":
				result = new PrimaryGermanGreetingService(greetingRepository);
				break;
			default:
				result = new PrimaryGreetingService(greetingRepository);
		}
		return result;
	}
}
