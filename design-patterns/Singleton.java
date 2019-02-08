@Singleton
public class PoolManager {

private Queue<Object> poolObjects = new LinkedBlockingQueue<>(1_000);

private PoolManager() {
	for (int i = 0; i<=100; i++)
		pooledObjects.offer(new Object()); 
}

public void returnObject(Object object) {
	pooledObjects.offer(object);
}

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


