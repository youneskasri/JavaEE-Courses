public static void main(String [] args) {
	try {
		/** Initialize the RestaurantService */
		RestaurantService restaurantService =
			new RestaurantService(
				new RestaurantRepositoryImpl());
		/** Creating Data for Restaurants */
		Table table1 = new Table("Table 1", BigInteger.ONE, 6);
		Table table2 = new Table("Table 2", BigInteger.valueOf(2), 4);
		List<Table> tableList = new ArrayList();
		tableList.add(table1);
		tableList.add(table2);
		Restaurant restaurant1 = new Restaurant"Big-O Restaurant", 
						"1", tableList);
		// .. restaurant2 & 3
		restaurantService.add(restaurant1);
		restaurantService.add(restaurant2);
		restaurantService.add(restaurant3);


		Collection<Restaurant> restaurants = restaurantService.getAll();

		restaurants.stream().forEach(restaurant ->  {
			System.out.println("Restaurant :"+restaurant);
		});

	} catch (Exception e) {
		System.out.println("Exception " + ex.getMessage());
	}
}
