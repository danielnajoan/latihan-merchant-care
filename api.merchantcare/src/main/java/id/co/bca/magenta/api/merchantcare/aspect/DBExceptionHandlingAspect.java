package id.co.bca.magenta.api.merchantcare.aspect;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import id.co.bca.magenta.api.merchantcare.entity.exception.RewardDataAccessException;

@Aspect
@Component
public class DBExceptionHandlingAspect {
	private static final Logger logger = LoggerFactory.getLogger(DBExceptionHandlingAspect.class);

	public static final String EMAIL_FAILURE_MSG = "Failed sending an email to Mister Smith : ";
//	public final static String LOG4J_PROPERTIES = StaticVariable.LOG4J_PATH;
	// public final static String LOG4J_PROPERTIES =
	// "/bcamagen/app/config/api.inventory.log4j.properties";

//	private Logger logger;

	// TODO-10 OPTIONAL REQUIREMENT #3: Use AOP to log an exception.
	// (Optional): Configure this advice method to enable
	// logging of exceptions thrown by Repository class methods.
	// Select the advice type that seems most appropriate.
	@AfterThrowing(value = "execution(* update*(*))", throwing = "e")
	public void implExceptionHandling(RewardDataAccessException e) {
		// Log a failure warning
//		logger = Logger.getLogger(getClass());
//		PropertyConfigurator.configure(LOG4J_PROPERTIES);
		logger.warn(EMAIL_FAILURE_MSG + e + "\n");

	}

}
