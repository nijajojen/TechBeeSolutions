package calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

	
		Calculator cal;
	
	@Before
	public void setUp() {
		 cal= new Calculator();
	}
	
	@Test
	public void testForCorrectSum() {
		int val=cal.sum(5, 5);
		assertEquals(10, 10);
	}
	
	@Test
	public void testForDiff() {
		int val=cal.difference(5, 5);
		assertEquals(0, 0);
	}
	
	@Test
	public void testForProd() {
		int val=cal.product(5, 5);
		assertEquals(25, 25);
	}
	
	@Test
	public void testForDiv() {
		int val=cal.division(5, 5);
		assertEquals(0, 0);
	}
	
	@After
	public void close() {
		System.out.println("Test finishes...");
	}
	
	

}
