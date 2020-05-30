package smartbytes.restassured.log4jscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLog4J {

	private static final Logger logger = LogManager.getLogger(TestLog4J.class);
	
	@Test
	public void logInfoMessage() {
		logger.info("This is information message");
	}
	@Test
	public void logInfoMessage1() {
		logger.warn("This is information message for logInfoMessage");
	}
	@Test
	public void logWarnMessage() {
		logger.warn("This is warning message");
	}
	@Test
	public void logErrorMessage() {
		int marks=40;
		if(marks <=50) {
			logger.error("This is error message : marks must be more than 50");
		}
		
	}
}
