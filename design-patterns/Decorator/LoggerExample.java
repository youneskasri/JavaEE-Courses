/* Third-party Logged */
public interface LogMessage {
	void printMessage();
	String getMessage();
	void setMessage(String message);
}

/* If I want to decorate the Logger, I need to implement the interface 
Abstract b/c i don't want to implement all the methods 
*/
@Decorator
@Priority(10)
public abstract class LogMessageFormatter implements LogMessage {
	
	@Any
	@Delegate
	@Inject
	@ComplexMessage /* Only the instances  annotated with this  are 
decorated
	private LogMessage logMessage;

	@Override
	public void printMessage() {
		String message = logMessage.getMessage();
		message = LocalDate.now().toString().concat(message);
		logMessage.setMessage(message);
	}
}

@Decorator 
@Priority(20)
public abstract class LogMessageJSONFormatter implements logMessage {
	@Any
	@Delegate
	@Inject
	private  LogMessage logMessage;

	public void printMessage() {
		String message = logMessage.getMessage();
		String jsonMessage = 
JsonbBuilder.create().toJson(message);
		logMessage.setMessage(jsonMessage);
	}
}

/* avec Priority, the timestamp is added first,
then message is formatted to JSON,
then the original output method is called */	
