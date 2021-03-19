package main;

/**
 * NULL Database Connection Exception
 * @author vishnu.jangid_metacu
 *
 */
public class NullDBConnectionException extends Exception {

	/**
	 * Constructor to Initialize Exception
	 */
	public NullDBConnectionException() {
		super();
	}
	
	/**
	 * Constructor to Initialize Exception with given message
	 * @param msg String, message
	 */
	public NullDBConnectionException(String msg) {
		super(msg);
	}
}
