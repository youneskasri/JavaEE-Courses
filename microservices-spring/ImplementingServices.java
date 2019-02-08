public class ReadOnlyBaseService<TE, T> {

	private ReadOnlyRepository<TE, T> repository;

	ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
	 	this.repository = repository;
	}
}

public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {
	private Repository<TE, E> _repository;

	public BaseService(Repository<TE, T> repository) {
		super(repository);
		_repository = repository;
	}

	public void add(TE entity) throws Exception {
		_repository.add(entity);
	}

	public Collection<TE> getAll() {
		return _repository.getAll();
	}
}

public class RestaurantService extends BaseService<Restaurant, 
BigInteger> {
	private RestaurantRepository<Restaurant, String) restaurantRepository;

	public RestaurantService(RestaurantRepository repository) {
		super(repository);
		restaurantRepository = repository;	
	}

	@Override
	public Collection<Restaurant> getAll() {
		return super.getAll();
	}

	@Override
	public void add(Restaurant restaurant) throws Exception  {
		if (restaurantRepository.contains(restaurant.getName()))
			throw new Exception(String.format(
			"There is already a restaurant with the 				name - %s", 
			restaurant.getName());

		if (restaurant.getName() == null || 
			restaurant.getName().trim().length == 0 )
			throw new Exception("Restaurant name cannot be 			null or empty String");
		
		super.add(restaurant);
	}
}
