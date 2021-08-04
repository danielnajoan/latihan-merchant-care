package id.co.bca.magenta.api.merchantcare.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import id.co.bca.magenta.api.merchantcare.monitor.MonitorFactory;
import id.co.bca.magenta.api.merchantcare.util.ErrorDetail;
import id.co.bca.magenta.api.merchantcare.util.StaticVariable;

@Aspect
@Component
// @ControllerAdvice
public class LoggingAspect extends ResponseEntityExceptionHandler {
	public final static String BEFORE = "'Before'";
	public final static String AROUND = "'Around'";
	public final static String AFTER = "'After'";
	public final static String AFTERTHROWING = "'After Throwing'";
	public final static String AFTERRETURNING = "'After Returning'";
//	public final static String LOG4J_PROPERTIES = StaticVariable.LOG4J_PATH;

	private Logger logger = LoggerFactory.getLogger(getClass());
	private MonitorFactory monitorFactory;

	private ErrorDetail errorDetail;

	public ErrorDetail getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(ErrorDetail errorDetail) {
		this.errorDetail = errorDetail;
	}

	@Autowired
	public LoggingAspect(MonitorFactory monitorFactory) {
		super();
		this.monitorFactory = monitorFactory;
	}

	// // ############ LOG FOR findByCustom return List<Induk> ############
	// @AfterReturning(value = "execution(* find*(..))", returning = "induk")
	// public void implLogging_findIndukByCustom(JoinPoint joinPoint,
	// List<Induk> induk) {
	// PropertyConfigurator.configure(LOG4J_PROPERTIES);
	// logger.info(AFTERRETURNING + " - " + joinPoint.getTarget().getClass() +
	// //
	// "; Executing on " + joinPoint.getSignature().getName() + //
	// "() method");
	// logger.info(AFTERRETURNING + " return the sample following induk object
	// on first index : " + induk.get(0));
	// }
	//
	// // ############ LOG FOR monitor find.. function ############
	// @Around("execution(* find*(..))")
	// public Object monitor_find(ProceedingJoinPoint repositoryMethod) throws
	// Throwable {
	// String name = createJoinPointTraceName(repositoryMethod);
	// Monitor monitor = monitorFactory.start(name);
	// PropertyConfigurator.configure(LOG4J_PROPERTIES);
	// try {
	// return repositoryMethod.proceed();
	// } finally {
	// monitor.stop();
	// logger.info(AROUND + " monitor find.. function - " + monitor);
	// }
	// }
	//
	// // ############ LOG FOR findByCustom return List<Induk> ############
	// @Before("execution(void save*(..))")
	// public void implLogging(JoinPoint joinPoint) {
	// PropertyConfigurator.configure(LOG4J_PROPERTIES);
	// logger.info(BEFORE + " advice implementation - " +
	// joinPoint.getTarget().getClass() + //
	// "; Executing before " + joinPoint.getSignature().getName() + //
	// "() method");
	// }
	// ***************** PINDAH EXCEPTION KE CLASS COMMONEXCEPTIONHANDLINGASPECT
	// *****************
	// @AfterThrowing(value = "execution(* save*(..))", throwing = "e")
	// public void implLogging(JoinPoint joinPoint, Exception e) {
	// ErrorDetail _fillErrorDetail=new ErrorDetail();
	// _fillErrorDetail.setDetailmessage("Rollback - "+e.getMessage());
	// _fillErrorDetail.setStatus(HttpStatus.CONFLICT.value());
	// _fillErrorDetail.setMessage(HttpStatus.CONFLICT.name());
	// this.setErrorDetail(_fillErrorDetail);
	// logger.info(AFTERTHROWING + " advice implementation - " +
	// joinPoint.getTarget().getClass() + //
	// "; Executing before " + joinPoint.getSignature().getName() + //
	// "() method");
	// logger.info(AFTERTHROWING + " return the following reward object : " +
	// e.getMessage());
	// }
	//
	// // ############ Exception Handling for Insert and Update ############
	// @ExceptionHandler(value = { Exception.class })
	// protected ResponseEntity<Object> handleConflict(RuntimeException ex,
	// WebRequest request) {
	// return handleExceptionInternal(ex, this.getErrorDetail(), new
	// HttpHeaders(), HttpStatus.CONFLICT, request);
	// }
	// *******************************************************************************************
	// @Before("execution(* find*())")
	// public void implLogging(JoinPoint joinPoint) {
	// PropertyConfigurator.configure(LOG4J_PROPERTIES);
	// logger.info(BEFORE + " advice implementation - " +
	// joinPoint.getTarget().getClass() + //
	// "; Executing before " + joinPoint.getSignature().getName() + //
	// "() method");
	// }

	// @AfterThrowing(value = "execution(* *(*))", throwing = "e")
	// public void implLogging(JoinPoint joinPoint) {
	// logger.info(BEFORE + " advice implementation - " +
	// joinPoint.getTarget().getClass() + //
	// "; Executing before " + joinPoint.getSignature().getName() + //
	// "() method");
	//
	// }

	// @Around("execution(* find*(*))")
	// public Object monitor1(ProceedingJoinPoint repositoryMethod) throws
	// Throwable {
	// String name = createJoinPointTraceName(repositoryMethod);
	// Monitor monitor = monitorFactory.start(name);
	// PropertyConfigurator.configure(LOG4J_PROPERTIES);
	// try {
	// return repositoryMethod.proceed();
	// } finally {
	// monitor.stop();
	// logger.info(AROUND + " advice implementation - " + monitor);
	// }
	// }

	private String createJoinPointTraceName(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		StringBuilder sb = new StringBuilder();
		sb.append(signature.getDeclaringType().getSimpleName());
		sb.append('.').append(signature.getName());
		return sb.toString();
	}
}