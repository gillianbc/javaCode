package Logging;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4JPropertiesTest {
	static Logger log = Logger.getLogger(Log4JPropertiesTest.class);
	static Logger log2 = Logger.getLogger("Bacon Sandwich");
	static Logger log3 = Logger.getLogger(Log4JPropertiesTest.class + "- Bacon Sandwich");

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		log.debug("This is a debug message");
		
		log.info("This is an info message");
		
		log.fatal("Oooh - fatal - this is serious");
		
		log.error("The prefix of my log statements is the name of the class running " + log.getName());
		
		log2.info("But I could use any name - see!");
		
		log3.info("Or a combo of both");
		
		myMethod();
	}

	private static void myMethod() {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			log.error("This is an exception", e);
		}
	}
}
