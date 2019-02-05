public interface ReadOnlyRepository<TE, T> {
	
	boolean contains(T id);
	TE get(T id);
	Collection<TE> getAll();
}

public interface Repository extends ReadOnlyRepository<TE, T> {
	
	void add(TE entity);
	void update(TE entity);
	void remove(T id);
}

public interface RestaurantRepository 
	extends Repository<Restaurant, String> {

	boolean containsName(String name);
} 

public  RestaurantRepositoryIml implements RestaurantRepository {

	/** In-memory Repository */
	private Map<String, Restaurant> restaurants
		= new HashMap();

	@Override
	public containsName(String name) {
		return restaurants.containsKey(name);
	}

	// ... Implementing the rest of the methods
}



 
