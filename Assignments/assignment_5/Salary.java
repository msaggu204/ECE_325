package ece325_assignment5;

public class Salary {
	
	/**
	 * Returns the amount of pay a band member will get (in dollars). This amount is computed by adding the bonus (if any)
	 * to the base salary and then deducting the amount spent on snacks. So, if a band member earned 100 dollars, spent 50 on snacks,
	 * and earned a bonus of 10 (%), their pay will be 60 dollars. 
	 * 
	 * Note: The current implementation of this method is extremely buggy and can easily be abused by anyone.
	 * 
	 * @param salary The base salary earned by this band member during this salary period (in dollars).
	 * @param snacksAmount The total amount spent by this band member on snacks during this salary period (in dollars).
	 * @param bonus The bonus percentage that the band member earned this salary period (in percentage).   
	 * @return the amount of pay a band member will get (in dollars)
	 */
	public static Double pay(Double salary, Double snacksAmount, Integer bonus) {
		
		if(salary == null || snacksAmount == null || bonus == null) {
			throw new IllegalArgumentException("Salary, snacks, or bonus cannot be null!");
		}
		else if(salary < 0d || salary > 1000d) {
			throw new IllegalArgumentException("Salary must be between $0 and $1000!");
		}
		else if(snacksAmount < 0) {
			throw new IllegalArgumentException("The amount of snacks cannot be negative!");
		}
		else if(bonus < 0 || bonus > 10) {
			throw new IllegalArgumentException("The bonus can only be an integer between 0 and 10 (%)!");
		}
		// If we have no null or out of range values, calculate gross pay
		Double pay = (bonus*0.01d + 1)*salary;
		if(snacksAmount > pay) {
			throw new IllegalArgumentException("A band member cannot spend more on snacks than they earn!");
		}
		else {
			// Net pay
			return pay - snacksAmount;
		}
	}
}
