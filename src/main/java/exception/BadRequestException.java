/**
 * 
 */
package exception;

/**
 * @author Harshita
 *
 */
public class BadRequestException extends Exception {

	/**
	 * 
	 */
	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BadRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BadRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
