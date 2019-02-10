@Stateless
@Path("/customers")
public class CustomerEndPoint  {

	@Inject @CustomerEvent(CustomerEvent.Type.ADD)
	private Event<Customer> customerAddEvent;

	@Inject @CustomerEvent(.. REMOVE)
	private Event<Customer> customerRemoveEvent;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newCustomer(Customer customer) {
		customerAddEvent.fire(customer);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeCustomer(Customer customer) {
		customerRemoveEvent.fire(customer);
	}
}


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target((ElementType.FIELD, ElementType.PARAMETER)
public @interface CustomerEvent {

	Type value();
	enum Type { ADD, REMOVE }
}
