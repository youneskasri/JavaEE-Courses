@Interceptor
@Transactional
public class LoggerInterceptor {
	
	@Inject // let's assue i already have a logger instance managed  by CDI
	private Logger logger;

	@AroundInvoke
	private Object doMethodLogging(InvocationContext ic) {
		List<String> params=Stream.of(ic.getParameters()).map(Object::toString)
			.collect(Collectors.toList());
		String methodName = ic.getMethod().getName();

		// Sysout: Invoked <methodName> with <params>

		returnValue = c.proceed();
		// Sysout: method returned <returnValue>
		return returnValue;
	}

	// For Constructos
	@AroundConstruct
	private void doClassLogging(InvocationContext ic) {
		long start = System.currentTimeMillis();
		ic.proceed();
		log end = System.currentTimeMillis();
		logger.info("Execution time = " + (end - start) );
	}
}
