public abstract class Entity<T> {
	protected T id;
	protected String name;
}

public abstract  class BaseEntity<T> extends Entity<T> { 
	
	@Getter @Setter
	private boolean isModified;
	
	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
		isModified = false;
	}
}

public class Table extends BaseEntity<BigInteger> {
	@Getter @Setter
	private int capacity;

	public Table(BigInteger id, String name, int capacity) {
		super(id, name);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return new StringBuilder("ID = ").append(id)
			.append(", Name = ").append(name)
			.append(", Capacity = ").append(capacity)
			.toString();
	}
}

@ToString
public class Restaurant extends BaseEntity<String> {

	@Getter @Setter
	private List<Table> tables = new ArrayList<>();

	public Restaurant(String id, String name, List<Table> tables) {
		super(id, name):
		this.tables = tables;
	}
}

 
