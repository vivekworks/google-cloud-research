package dev.vivekts.jer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaErrorReportingApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaErrorReportingApplication.class);

	public static void main(String[] args) {
		LOGGER.error("Logging ERROR with JavaErrorReportingApplication");
		SpringApplication.run(JavaErrorReportingApplication.class, args);
	}

}
