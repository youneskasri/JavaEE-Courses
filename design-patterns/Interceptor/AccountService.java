@Interceptors(LoggedInterceptor.class)
public class AccountService {

	AccountService() { }

	@ExcludeClassInterceptors
	void upgradeAccount(String accountNumber) {
	
	}

	void auditAccount(String accountNumber) {

	}
}
