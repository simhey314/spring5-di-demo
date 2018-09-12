package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
		@PropertySource("classpath:datasource.properties"),
		@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

	@Autowired
	Environment environment;

	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.url}")
	private String url;

	@Value("${jms.user}")
	private String jmsuser;
	@Value("${jms.password}")
	private String jmspassword;
	@Value("${jms.url}")
	private String jmsurl;

	/*
	 * auto configured by spring boot, not necessary here
	 */
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

	@Bean
	public FakeDataSource fakeDataSource() {
		final FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(environment.getProperty("USERNAME"));
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		final FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(jmsuser);
		fakeJmsBroker.setPassword(jmspassword);
		fakeJmsBroker.setUrl(jmsurl);
		return fakeJmsBroker;
	}
}
