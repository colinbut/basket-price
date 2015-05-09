/**
 * 
 */
package com.mycompany.basket_price.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mycompany.basket_price.util.PriceBasketApplicationOutputWriter;

/**
 * @author colin
 *
 */
public class PriceBasketApplicationOutputReaderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testWriteOutput() {
		
		String expected = new StringBuilder("Subtotal: £3.10")
								.append("Apples 10% off: -10p")
								.append("Total: £3.00").toString();
		
		//String actual = PriceBasketApplicationOutputWriter.writeOutput(receipt)
		
		//assertEquals(expected, actual);
		
	}

}
