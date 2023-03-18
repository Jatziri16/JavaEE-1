package pruebas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class Log4Prueba 
{
	public static void main(String[] args) 
	{
		//Logger logger = (Logger) LogManager.getLogger("EjemploLog4J");
		//PatternLayout patron = new PatternLayout("%m %n");
		//ConsoleAppender consola = new ConsoleAppender();
		
		Logger logger = (Logger) LogManager.getRootLogger();
		logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
	}
}
