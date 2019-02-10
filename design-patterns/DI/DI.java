public interface Subject {}

public class Maths implements Subject {}

public class Target {
	
	@Favourites // Qualifier
	@Inject
	Subject arabic;

/*	@Inject 
	Maths maths; */

}

@Favourites
public class Arabic implements Subject {}
// Throw an exception at startup = AMBIGUOUS DEPENDENCY
// Solution = Qualifiers 


@Qualifier
@Retention(RUNTIME)
@Target({TYPE, PARAMETER, FIELD, CONSTRUCTOR})
public @interface Favourites {
	
}
