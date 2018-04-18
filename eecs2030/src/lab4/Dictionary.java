package lab4;

import java.io.InputStream;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * An implementation of an immutable dictionary.
 *
 */
public class Dictionary {

	private SortedSet<String> words;

	// private String currentWord;

	private final void readDictionary() {
		InputStream in = this.getClass().getResourceAsStream("dictionary.txt");
		if (in == null) {
			throw new RuntimeException("dictionary.txt is missing");
		}

		Scanner dictionaryInput = new Scanner(in);
		while (dictionaryInput.hasNext()) {
			String word = dictionaryInput.next();
			this.words.add(word.trim());
		}
		dictionaryInput.close();

	}

	/**
	 * Initializes a dictionary by reading the default dictionary from a file.
	 */
	public Dictionary() {

		this.words = new TreeSet<String>();
		this.readDictionary();

	}

	public int size() {

		return this.words.size();
	}

	public boolean lookUp(String word) {

		if (this.words.contains(word.toLowerCase()) || this.words.contains(word.toUpperCase())) {
			return true;
		}
		return false;
	}

	public SortedSet<String> wordsStartingWith(String prefix) {
		SortedSet<String> newWords = new TreeSet<String>();
		for (String str : this.words) {
			if (str.toLowerCase().startsWith(prefix.toLowerCase())) {

				newWords.add(str);
			}
		}
		return newWords;
	}

}
