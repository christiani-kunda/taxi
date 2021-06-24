package demo.taxi.com.exception;

/**
 * The Class ObjectNotFoundException.
 *
 * @author Christian Iradukunda
 */
public class ObjectNotFoundException extends RuntimeException{

	public ObjectNotFoundException(final String message) {
		super(message);
	}
}