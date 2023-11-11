package ece325_assignment5;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

class TestSalary {
		
	@Test
	void testSalary() {
		// Null test
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(null, 0d, 10);
		});
		// Outside of acceptable range
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(1001d, 0d, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(-1d, 0d, 10);
		});
	}
	
	@Test
	void testSnacks() {
		// Null test
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, null, 10);
		});
		// More spent on snacks than gross pay
		// Net pay cannot = -ive
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, 1d, 10);
		});
		// Outside of acceptable range
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, -1d, 10);
		});
	}
	
	@Test
	void testBonus() {
		// Null test
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, 0d, null);
		});
		// Outside of acceptable range
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, 0d, -1);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(0d, 0d, 11);
		});
	}
	
	@Test
	void testCorrect() {
		// See if we get the correct results
		// For this assignment, you can set delta to 0.001.
		assertEquals(60d, Salary.pay(100d, 50d, 10), 0.001);
		// Testing edge cases
		assertEquals(0d, Salary.pay(0d, 0d, 0), 0.001);
		assertEquals(0d, Salary.pay(0d, 0d, 10), 0.001);
		assertEquals(1000d, Salary.pay(1000d, 0d, 0), 0.001);
		assertEquals(0d, Salary.pay(1000d, 1000d, 0), 0.001);
		// Testing floating point values
		assertEquals(1030.31, Salary.pay(1000d, 69.69, 10), 0.001);
		assertEquals(3.485, Salary.pay(69.69, 69.69, 5), 0.001);
	}
}