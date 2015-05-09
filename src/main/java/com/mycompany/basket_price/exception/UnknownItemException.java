/**
 * 
 */
package com.mycompany.basket_price.exception;

/**
 * @author colin
 *
 */
public class UnknownItemException extends IllegalArgumentException {

	private static final long serialVersionUID = -5019048764088206146L;

	public UnknownItemException(String message){
		super(message);
	}
}
