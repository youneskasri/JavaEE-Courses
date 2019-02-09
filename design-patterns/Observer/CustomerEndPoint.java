@Stateless
@Path("/customers")
public class CustomerEndPoint  {

	@Inject
	private Event<Customer> customerAddEvent;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newCustomer(Customer customer) {
		customerAddEvent.fire(customer);
	}
}
