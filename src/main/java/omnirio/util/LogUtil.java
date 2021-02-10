package omnirio.util;

import org.apache.log4j.Logger;

public class LogUtil {
	
	public static Logger getInstance() {
	
		try {
		
			String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			return Logger.getLogger(callingClassName);
	
		}catch(Exception e) {
			return null;
		}
	}

}