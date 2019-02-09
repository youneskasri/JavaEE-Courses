public class AuthenticationService {

	public void createAuthenticationCredentials(@Observes Customer 
customer) {
		// create credentials
	}
}

public class CustomerService {
	public void createCustomer(@Observes Customer customer) {
		// add new customer
	}
}

public class EmailService { 

	public void sendWelcomeEmail(@Observes Customer customer) {
		// Send welcome email
	}
}

