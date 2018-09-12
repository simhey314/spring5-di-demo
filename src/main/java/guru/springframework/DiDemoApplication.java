package guru.springframework;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(final String[] args) {
		final ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		final MyController controller = (MyController) ctx.getBean("myController");

		final FakeDataSource dataSource = ctx.getBean(FakeDataSource.class);
		final FakeJmsBroker jmsBroker = ctx.getBean(FakeJmsBroker.class);

		final Logger logger = LoggerFactory.getLogger(DiDemoApplication.class);

		logger.info("Get the fake data source: " + dataSource);
		logger.info("Get the fake jms broker: " + jmsBroker);
	}
}
