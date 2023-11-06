package lab7.set_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T element =iter.next();
			if(p.test(element)) {
				iter.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T>iter = coll.iterator();
		while (iter.hasNext()) {
			T element =iter.next();
			if(!p.test(element)) {
				iter.remove();
			}
		}
		
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		 Set<T> result = new HashSet<>();
	        for (T element : coll) {
	            if (p.test(element)) {
	                result.add(element);
	            }
	        }
	        return result;
		
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		  int index = 0;
	        for (T element : coll) {
	            if (p.test(element)) {
	                return index;
	            }
	            index++;
	        }
		return -1;
	}
	public static void main(String[] args) {
		
		  // Create a list of integers
        List<Integer> num = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        // Example of using the remove method
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        MyPredicates.remove(num, evenPredicate);
        System.out.println("List after removing even numbers: " + num);

        // Example of using the retain method
        Predicate<Integer> greaterThanFivePredicate = n -> n > 5;
        MyPredicates.retain(num, greaterThanFivePredicate);
        System.out.println("List after retaining numbers greater than 5: " + num);

        // Example of using the collect method
        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape"));
        Predicate<String> startsWithBPredicate = s -> s.startsWith("c");
        Set<String> bWords = MyPredicates.collect(words, startsWithBPredicate);
        System.out.println("Words starting with 'c': " + bWords);

        // Example of using the find method
        Predicate<String> lengthGreaterThanFivePredicate = s -> s.length() > 5;
        int index = MyPredicates.find(words, lengthGreaterThanFivePredicate);
        System.out.println("Index of the first word with length greater than 5: " + index);
    }
}
