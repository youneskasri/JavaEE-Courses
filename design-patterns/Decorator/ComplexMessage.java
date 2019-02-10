@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ComplexMessage {

}

@ComplexMessage
public class SystemMessage implements LogMessage {
	
	@Override
	public void printMessage() {

	}
	
	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public void setMessage(String message) {

	}
}
