
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("Configuration")
@Startup
@Singleton
public class PoolManager {

private Queue<Object> poolObjects;


@PostContruct
void constructExpensiveObjects() {
	pooledObjects = new  LinkedBlockingQueue<>(1_000);
	for (int i = 0; i<=100; i++)
		pooledObjects.offer(new Object()); 
}

@AccessTimeout(value = 30, unit = TimeUnit.SECONDS)
@Lock(LockType.WRITE)
public void returnObject(Object object) {
	pooledObjects.offer(object);
}

@Lock(LockType.READ)
public Object borrowObject() {
	return pooledObjects.poll();
}


}

public class UsePoolManager {

	@Inject
	private PoolManager poolManager;

	public void usePooledObject() {
		Object object = poolManager.borrowObject();
		// use object
		poolManager.returnObject(object);
	}
}


