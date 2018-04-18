package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Random;

public class Die {

	private SortedMap<Integer, String> valueMap;
	private int n; // number of faces
	private int currentVal; // a number between 1 and n
	private String currentFace; // selected face

	public Die() {

	}

	public Die(String[] faces) {

		this.n = faces.length; // DECLARES 'n'

		if (n == 0) {
			throw new IllegalArgumentException("Must have at least 1 face side");
		}

		SortedMap<Integer, String> theMap = new TreeMap<Integer, String>();

		for (int i = 0; i < faces.length; i++) {
			this.currentVal = i + 1; // initialize these variables
			this.currentFace = faces[i];
			theMap.put(this.currentVal, this.currentFace);

		}

		this.valueMap = theMap;

	}

	public Die(Die other) {

		// Die other = (Die) other; // create a new Die from other

		this.currentFace = other.currentFace;
		this.currentVal = other.currentVal;

		this.valueMap = other.valueMap;

	}

	public int getNumberOfFaces() {

		return Die.this.n;

	}

	public String roll() {

		Random rand = new Random();
		int r = rand.nextInt(this.n) + 1; // generates random number between 1 and n

		// this.currentVal = r;

		// System.out.println("random number is: " + r + " and it's value is " +
		// getValue());
		this.currentFace = this.valueMap.get(r);
		return this.valueMap.get(r);

	}

	public String getValue() {

		String result = this.currentFace;
		return result;

	}

	public SortedMap<Integer, String> getValueMap() {

		return new TreeMap<Integer, String>(this.valueMap);

	}

	@Override
	public int hashCode() {

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + valueMap.get(i + 1).hashCode();
		}

		return sum;

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Die other = (Die) obj;

		if (!this.getValue().equals(other.getValue())) {
			return false;
		}

		List<String> strings = new ArrayList<String>(this.valueMap.values());
		List<String> otherStrings = new ArrayList<String>(other.valueMap.values());
		Collections.sort(strings);
		Collections.sort(otherStrings);

		if (!strings.equals(otherStrings)) {
			return false;
		}

		return true;

	}

	@Override
	public String toString() {

		String result = "";

		for (int i = 0; i < n - 1; i++) {
			result = result + valueMap.get(i + 1) + ", ";
		}

		result = result + valueMap.get(n);

		System.out.println(result);
		return result;

	}

	public static void main(String[] args) {

		String[] greetings = { "hello", "how", "are", "you" };
		Die d = new Die(greetings);

		System.out.println("number of faces: " + d.getNumberOfFaces());
		System.out.println("ROLL : " + d.roll());
		System.out.println("de.getValue(): " + d.getValue());
		System.out.println("hashcode: " + d.hashCode());
		System.out.println("d.toString(): " + d.toString());

	}

}
