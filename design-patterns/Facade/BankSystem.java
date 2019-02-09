/**
* FACADE
*/

@Stateless
public class BankSystem {

	@EJB /* To Inject */
	private CreditRatingService creditRatingService;

	@EJB
	private RepaymentPayabilityService  rps;

	/*
	* Injecting Other Service
	*/

	public boolean processLoanApplication(Customer customer, Double 
principle, Double income, Integer months) {
		/* USES THE PREVIOUS SERVICES  .. */
		
		return true;
	}


	
	
}
