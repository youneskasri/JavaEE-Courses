@RestController
@RequestMapping("/v1/restaurants")
public class  RestaurantController {

	protected static final logger =
		Logger.getLogger(RestaurantController.class);

	protected RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(value = "/{idRestaurant}", 
		method = RequestMethod.GET)
	public ResponseEntity<Entity> findById(@PathVariable String 
	idRestaurant) {
		Entity restaurant;
		try {
			restaurant = restaurantService.findById(idRestaurant);
		} catch (Exception e) {
			
		}
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Restaurant>> findByName(
		@RequestParam String name) {
		
		Collection<Restaurant> restaurants = new ArrayList<>();
		try {
			restaurants = 
restaurantService.findByName(name);
		}catch(Exception e) {
			// TODO
		}
		return  restaurants;
	}

	@PostMapping
	public ResponseEntity<Restaurant> add(@RequestBody RestaurantVO){
		Restaurant restaurant = new Restaurant();
		BeanUtils.copyProperties(restaurantVO, restaurant);
		try { restaurantService.add(restaurant); }
		catch(Exception e) {}
		return new ResponsEntity<>(restaurant, HttpStatus.OK);
	}
}
