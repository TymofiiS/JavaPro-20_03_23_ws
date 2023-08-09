package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	public static final Logger other = 
			LoggerFactory.getLogger("OTHER"); 
	
	public static final Logger err = 
			LoggerFactory.getLogger("ERR"); 
}
