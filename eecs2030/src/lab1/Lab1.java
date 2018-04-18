package lab1;

import java.util.List;
import java.util.Collections;

/**
 * Short methods reviewing fundamental Java concepts covered in EECS1021,
 * EECS1022, and EECS1720
 * 
 * @author Rajvi Chavada
 * EECS 2030
 * test
 * test2
 *
 */
public class Lab1 {

	/**
	 * The course name for EECS2030.
	 */
	public static final String COURSE_NAME = "Advanced Object Oriented Programming";

	/**
	 * The smallest address allowed by yourAgeChecked.
	 */
	public static final int MIN_ADDRESS = 1;

	/**
	 * The greatest address allowed by yourAgeChecked.
	 */
	public static final int MAX_ADDRESS = 20000000;

	/**
	 * The smallest birth year allowed by yourAgeChecked.
	 */
	public static final int MIN_BIRTH_YEAR = 1917;

	/**
	 * The greatest birth year allowed by yourAgeChecked.
	 */
	public static final int MAX_BIRTH_YEAR = 2016;

	private Lab1() {
		// empty by design
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minDouble() {
		return Double.MIN_VALUE;
	}

	/**
	 * Removes the last two digits of a positive integer base 10 number that is
	 * greater than <code>99</code>.
	 * 
	 * @param n
	 *            a positive integer number greater than 99
	 * @return the integer produced by removing the last two digits of n
	 */
	public static int removeLastTwoDigits(int n) {
		return n / 100;
	}

	/**
	 * Returns the last two digits of a positive integer base 10 number that is
	 * greater than <code>99</code>. If the last two digits start with a
	 * <code>0</code> then only the last digit is returned.
	 * 
	 * @param n
	 *            a positive integer number greater than 99
	 * @return the last two digits of n
	 */
	public static int lastTwoDigits(int n) {

		String str = Integer.toString(n);

		if (str.length() - 2 == 0) {
			return Integer.parseInt(str.substring(str.length() - 1, str.length()));
		} else {
			return Integer.parseInt(str.substring(str.length() - 2, str.length()));
		}
	}

	/**
	 * Computes the age (in years) of a person using the following convoluted
	 * algorithm:
	 * 
	 * <p>
	 * <ul>
	 * <li>start with the person's street <code>address</code>
	 * <li>double it
	 * <li>add 42 to the result from the previous step
	 * <li>multiply the previous step by 50
	 * <li>subtract the person's <code>birthYear</code> from the previous step
	 * <li>subtract 50 from the previous step
	 * <li>add the number of <code>birthdays</code> the person has had this year to
	 * the previous step
	 * <li>subtract 34 from the previous step
	 * <li>the last two digits of the previous step is the age of the person
	 * </ul>
	 * 
	 * @param address
	 *            the person's street address number
	 * @param birthYear
	 *            the person's birth year
	 * @param birthdays
	 *            the number of birthdays the person has had this year (either 0 or
	 *            1)
	 * @return the age of the person @pre. address is between MIN_ADDRESS and
	 *         MAX_ADDRESS, birthYear is between MIN_BIRTH_YEAR and MAX_BIRTH_YEAR,
	 *         and birthdays is 0 or 1
	 */
	public static int yourAge(int address, int birthYear, int birthdays) {

		int n = (((((((2 * address) + 42) * 50) - birthYear) - 50) + birthdays) - 34);
		return Lab1.lastTwoDigits(n);
	}

	/**
	 * Compute the average of two values.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 * @return the average of the two values
	 */
	public static double avg(int a, int b) {
		return (0.0 + a + b) / 2;
	}

	/**
	 * Returns the wind chill for air temperatures equal to or below 0 degrees
	 * Celcius and wind velocities equal to or greater than 5 km/h.
	 * 
	 * <p>
	 * Wind chill is an index that indicates how cold the weather feels to the
	 * average person when there is some wind. For example, if the air temperature
	 * is -5 degrees Celcius and the wind chill is -15 then it means that it feels
	 * similar to a windless day where the temperature is -15 degrees Celcius.
	 * 
	 * @param airTemp
	 *            the temperature in degrees Celcius
	 * @param windSpeed
	 *            the wind speed in km/h
	 * @return the wind chill index @pre. airTemp is less than or equal to 0 degrees
	 *         Celcius and windSpeed is greater than or equal to 5 km/h
	 * @see <a href="http://climate.weather.gc.ca/glossary_e.html#w"> Environment
	 *      and Climate Change Canada wind chill definition</a>
	 */
	public static double windChill(double airTemp, double windSpeed) {

		if (airTemp <= 0 && windSpeed >= 5) {
			double val = Math.pow(windSpeed, 0.16);
			double res = 13.12 + 0.6215 * airTemp + (0.3965 * airTemp - 11.37) * val;
			return res;
		}

		else
			throw new IllegalArgumentException("Values must be within range");
	}

	/**
	 * Determine if an integer <code>x</code> is odd.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is odd and false otherwise
	 */
	public static boolean isOdd(int x) {
		return x % 2 != 0;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is exactly on the perimeter of a
	 * circle with center <code>(0, 0)</code> and having radius equal to
	 * <code>1</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is exactly on the perimeter of the unit circle, and
	 *         false otherwise
	 */
	public static boolean isOnUnitCircle(double x, double y) {
		double check = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		if (check == 1.00) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Determine if the point <code>(x, y)</code> is inside the unit square. The
	 * unit square is the square whose sides have length 1, whose bottom left corner
	 * has coordinates (0, 0), and whose top right corner has coordinates (1, 1). A
	 * point on the perimeter of the unit square is considered to be inside the
	 * square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is inside the unit square, and false otherwise
	 */
	public static boolean isInsideUnitSquare(double x, double y) {
		if (x <= 1 && y <= 1 && x >= 0 && y >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is outside the unit square. The
	 * unit square is the square whose sides have length 1, whose bottom left corner
	 * has coordinates (0, 0), and whose top right corner has coordinates (1, 1). A
	 * point on the perimeter of the unit square is considered to be inside the
	 * square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is outside the unit square, and false otherwise
	 */
	public static boolean isOutsideUnitSquare(double x, double y) {
		if (((x > 1.0) || (y > 1.0)) || (x < 0) || (y < 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A version of yourAge where the arguments are checked to ensure that they have
	 * acceptable values.
	 * 
	 * <p>
	 * <code>address</code> must be greater than or equal <code>MIN_ADDRESS</code>
	 * and less than or equal to <code>MAX_ADDRESS</code>.
	 * 
	 * <p>
	 * <code>birthYear</code> must be greater than or equal
	 * <code>MIN_BIRTH_YEAR</code> and less than or equal to
	 * <code>MAX_BIRTH_YEAR</code>.
	 * 
	 * <p>
	 * <code>birthdays</code> must be equal to 0 or 1.
	 * 
	 * @param address
	 *            the person's street address number
	 * @param birthYear
	 *            the person's birth year
	 * @param birthdays
	 *            the number of birthdays the person has had this year
	 * @return the age of the person
	 * @throws IllegalAddressException
	 *             if address is less than MIN_ADDRESS or greater than MAX_ADDRESS
	 * @throws IllegalArgumentException
	 *             if birthYear is less than MIN_BIRTH_YEAR or greater than
	 *             MAX_BIRTH_YEAR
	 * @throws IllegalArgumentException
	 *             if birthdays is not 0 or 1
	 */
	public static int yourAgeChecked(int address, int birthYear, int birthdays) {

		if ((address < MIN_ADDRESS) || (address > MAX_ADDRESS)) {
			throw new IllegalAddressException();
		} else if ((birthYear < MIN_BIRTH_YEAR) || (birthYear > MAX_BIRTH_YEAR)) {
			throw new IllegalBirthYearException();
		} else if ((0 > birthYear) || (1 < birthYear)) {
			throw new IllegalBirthdaysException();
		} else {
			return Lab1.yourAge(address, birthYear, birthdays);
		}
	}

	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the range is
	 * considered outside of the range.
	 * 
	 * @param x
	 *            a value
	 * @param range
	 *            a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0 otherwise
	 */
	// DONE --------------------------------------------------------------------
	public static int contains(double x, Range range) {

		int result;
		double min = range.getMinimum();
		double max = range.getMaximum();

		if (x > min && x < max) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	// ---------------------------------------------------------------------------------
	/**
	 * Compares two <code>Range</code> instances by their widths. The width of a
	 * range is equal to the maximum value of the range minus the minimum value of
	 * the range.
	 * 
	 * @param r1
	 *            a Range
	 * @param r2
	 *            a second Range
	 * @return the value 0 if both Range instances are equal; -1 if r1 is narrower
	 *         than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		int result;
		double min1 = r1.getMinimum();
		double max1 = r1.getMaximum();
		double min2 = r2.getMinimum();
		double max2 = r2.getMaximum();

		double width1 = max1 - min1;
		double width2 = max2 - min2;

		if (width1 == width2) {
			result = 0;
		} else if (width1 < width2) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}

	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to Lab1.COURSE_NAME
	 */
	public static String getCourseName() {
		return Lab1.COURSE_NAME;
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"range from x to y"</code> where x is
	 * the minimum value of the range and y is the maximum value of the range.
	 * 
	 * @param r
	 *            a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {

		return "range from " + r.getMinimum() + " to " + r.getMaximum();

	}

	/**
	 * Returns the character located in the middle of the string. If <code>s</code>
	 * has an even number of characters then the middle character is taken to be the
	 * first character in the second half of the string (i.e., the middle character
	 * of the string <code>"abcd"</code> is <code>'c'</code>.
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 * @return the middle character of s
	 * @throws IllegalArgumentException
	 *             if s is empty
	 */
	public static char middleChar(String s) {
		int position;
		char middle;
		int length = s.length();

		if (length == 0) {
			throw new IllegalArgumentException("s is empty");
		}

		if (Lab1.isOdd(length) == true) {
			position = length / 2;
			middle = s.charAt(position);
		}

		else {
			position = length / 2;
			middle = s.charAt(position);
		}

		return middle;
	}

	/**
	 * Sorts a list of two integers so that the elements are in descending order
	 * (largest to smallest). The size of the list remains unchanged.
	 * 
	 * @param t
	 *            a list
	 * @throws IllegalArgumentException
	 *             if the size of list is not equal to 2
	 */
	public static void sort2(List<Integer> t) {
		Collections.sort(t);
		Collections.reverse(t);

		if (t.size() != 2) {
			throw new IllegalArgumentException("Size of list is not equal to 2");

		}
	}

	/**
	 * Returns the sum of the absolute value of the elements in a list. The sum of
	 * an empty list is <code>0</code>. The method does not modify the list.
	 * 
	 * @param t
	 *            a list
	 * @return the sum of the absolute value of the elements in a list
	 */
	public static double sumAbsolute(List<Double> t) {
		double result = 0.0;
		for (Double elem : t) {
			result += Math.abs(elem);
		}
		return result;
	}

	/**
	 * Replaces each string in a list with the uppercase version of the string. The
	 * size of the list remains unchanged. For example, the method would modify the
	 * list <code>["some", "random", "WoRdS"]"</code> to become
	 * <code>["SOME", "RANDOM", "WORDS"]"</code>.
	 * 
	 * @param t
	 *            a list of strings
	 */
	public static void toUpperCase(List<String> t) {

		String result = "";

		for (int i = 0; i < t.size(); i++) {
			result = t.get(i);
			result = result.toUpperCase();
			t.set(i, result);
		}
	}

}