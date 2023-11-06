package lab7.set_student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<>();

		for (String word : words) {
			WordCount wc = new WordCount(word, count(word));
			if (!result.contains(word)) {
				result.add(wc);
			}
		}
		return result;
	}

	public int count(String w) {
		int count = 0;
		for (String st : words) {
			if (w.equals(st)) {
				count++;
			}
		}
		return count;

	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				re.add(wc.getWord());
			}
		}

		return re;

	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> re = new TreeSet<String>();
		for (String word : words) {
			re.add(word);

		}

		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> re = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				int count = o1.getCount() - o2.getCount();
				if (count == 0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				return count;
			}

		});

		re.addAll(getWordCounts());
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> re = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				int count = o2.getCount() - o1.getCount();
				if (count == 0) {
					return o2.getWord().compareTo(o1.getWord());
				}
				return count;
			}

		});

		re.addAll(getWordCounts());
		return re;

	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(char pattern) {
		Set<String> re = new HashSet<String>();
		for (String word : words) {
			if (!(word.charAt(0) == pattern)) {
				re.add(word);
			}
		}
		return re;

	}

	public static void main(String[] args) {
		MyWordCount my = new MyWordCount();
		List<WordCount> re = my.getWordCounts();
		System.out.println(re);

		Set<String> re1 = my.getUniqueWords();
		System.out.println(re1);

		Set<String> re2 = my.getDistinctWords();
		System.out.println(re2);

		Set<WordCount> re3 = my.printWordCounts();
		System.out.println(re3);

		Set<WordCount> re4 = my.exportWordCountsByOccurence();
		System.out.println(re4);
		Set<String> re5 = my.filterWords('N');
		System.out.println(re5);

	}

}
