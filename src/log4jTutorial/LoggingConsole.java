package log4jTutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggingConsole {

	private static final Logger log = (Logger) LogManager.getLogger(LoggingConsole.class.getName());

	public static void main(String[] args) {
		log.trace("Trace Msg Logged");
		log.debug("Debug Msg Logged");
		log.info("Info Msg Logged");
		log.error("Error Msg Logged");
		log.fatal("Fatal Msg Logged");
	}

}
