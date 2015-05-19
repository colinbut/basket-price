/**
 * 
 */
package com.mycompany.basket_price.exception;

/**
 * Exception for an unknown item supplied
 * 
 * @author colin
 *
 */
public class UnknownItemException extends IllegalArgumentException {

	private static final long serialVersionUID = -5019048764088206146L;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public UnknownItemException(String message){
		super(message);
	}

}
