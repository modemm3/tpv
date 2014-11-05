package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogProperties {
	static
	{
		String ruta=System.getProperty("user.dir");
		PropertyConfigurator.configure(LogProperties.class.getResource("/resources/log4j.properties"));
//		PropertyConfigurator.configure("/resources/log4j.properties");
	}
	public static final Logger log = Logger.getLogger(LogProperties.class);
	public static void main(String[] args)
	{
		LogProperties.log.error("mensaje");
	}
}

