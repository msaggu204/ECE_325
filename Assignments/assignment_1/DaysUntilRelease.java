package ece325_assignment1;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;


public class DaysUntilRelease {
	
	/**
	 * 	Calculate the number of days until releaseDate.
	 * In other words, calculate the days between the date provided and the current date.
	 * @param releaseDate in the format yyyy-mm-dd (e.g., 2021-09-09)
	 * @return
	 */
	public static int calculateDaysUntilRelease(String releaseDate) throws Exception{
		// Allows us to read data from the user, parse/scan using the format that we require
		// returns the string in a date format in the calendar to be compared to today's date
		Date dayDate = new SimpleDateFormat("yyyy-MM-dd").parse(releaseDate);
		// Get today's date
		Calendar todayDate = Calendar.getInstance();
		// B/c ChronoUnits is usually in long type, we convert it to int, as the method requires this
		// Compare today's date to the date provided - gives difference between the days
		int daysLeft =  (int) ChronoUnit.DAYS.between(todayDate.toInstant(), dayDate.toInstant());
		// If the difference is negative, we do not display the negative number, but the string
		if(daysLeft < 0) {
			System.out.println("Album was already released!");
		}
		// If the days are positive (future release), we display the days remaining
		else {
			System.out.println("Release will be in " + daysLeft + " days");
		}
		return daysLeft;
	}
	
	public static void main(String[] args) throws Exception {
		// A sample test case, also think of other test cases yourself
		// You can assume the date string is always in the correct format
		String releaseDate = "2020-10-15";
		int daysLeft = calculateDaysUntilRelease(releaseDate);
		
		int daysLeft1 = calculateDaysUntilRelease("2022-10-31");
		
		calculateDaysUntilRelease("1969-06-09");
		
		calculateDaysUntilRelease("2025-09-01");
	}
}
