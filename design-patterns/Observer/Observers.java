public class AuthenticationService {

	public void createAuthenticationCredentials(@Observes 
@Priority(100)  
Customer 
customer) {
		// create credentials
	}
}

public class CustomerService {
	public void createCustomer(@Observes @Priority(10)
@CustomerEvent(CustomerEvent.Type.ADD) Customer 
customer) {
		// add new customer
	}

	public void removeCustomer(@Observers 
@CustomerEvent(CustomerEvent.Type.REMOVE) Customer customer) {
		// delete customer
	}
}

public class EmailService { 

	/* Default priority = CTE + 500 */
	public void sendWelcomeEmail(@Observes Customer customer) {
		// Send welcome email
	}
}

