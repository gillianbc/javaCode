package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 3, 2, 3, 5, 8, 4, 8);
		// find the double of the first even integer greater than 3
		// This is the dirty imperative way to do it
		int result = 0;
		for (int i : numbers) {
			if (i > 3 && i % 2 == 0) {
				result = i * 2;
				break;
			}
		}
		System.out.println(result);
		// This is the declarative way - define the rules to apply
		// stream - a very powerful type of iterator of the collection
		// map - a transformation to apply
		// findFirst - restrict the resultant set to first one
		System.out.println(numbers.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst());

		/*
		 * but what about performance? Using the old fashioned imperative method
		 * performs 8 operations before it returns us the result. If we use
		 * method calls in the declarative lambda style loop, we'll see that it
		 * still only uses 8 operations. The findFirst prevents it from checking
		 * subsequent numbers in the list
		 */
		System.out.println(numbers.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst());

		/*
		 * You can also use method calls for the filtering and mapping
		 */
		System.out.println(numbers.stream().filter(StreamsDemo::isGreaterThan3).filter(StreamsDemo::isEven)
				.map(StreamsDemo::doubleMe).findFirst());

		// === BASIC SYSOUT =====
		System.out.println("Basic sysout");
		numbers.stream().collect(Collectors.toSet()).forEach(System.out::println);
		numbers.stream().collect(Collectors.toSet()).forEach(p -> System.out.println("Number is " + p));

		/*
		 * Print out the numbers that are duplicates i.e. occur more than once
		 * in the stream
		 */
		System.out.println("Duplicates are:");
		numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);

		// Same as above but a different way of printing out
		numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1).collect(Collectors.toSet())
				.forEach(p -> System.out.println("Duplicated: " + p));

		// Simple boolean condition - has duplicates?
		if (numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1).count() > 0)
			System.out.println("Has duplicates");

		// Also see:
		// http://www.leveluplunch.com/java/examples/stream-terminal-operations-example/
		// ================== REDUCE
		// ===================================================
		// Sum of all numbers in stream
		System.out.println("Sum of all numbers: " + numbers.stream().reduce(0, (a, b) -> a + b));

		int sum = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
		System.out.println("Sum is " + sum);

		System.out.println(
				"Product of all even numbers: " + numbers.stream().filter(e -> e % 2 == 0).reduce(0, (a, b) -> a + b));
		// ================ TOARRAY
		// =====================================================

		Object[] objArray = numbers.stream().filter(e -> e % 2 == 0).toArray();
		System.out.println("Objarray length is: " + objArray.length);

		// ============ STREAM OF ======= FOREACH =====================
		Stream.of("Hello", "World").forEach(p -> System.out.print(p.length() + " - "));
		System.out.println();
		// ===== MIN ====== MAX ===== MAPTODOUBLE ======
		System.out.println("Minimum " + IntStream.of(1, 2, 3).min());
		// convert the optional to an int
		System.out.println("Minimum " + IntStream.of(1, 2, 3).min().getAsInt());

		System.out.println(Stream.of(1d, 2d, 3d).mapToDouble(Double::doubleValue).max());

		// =========ALLMATCH NONEMATCH ANYMATCH =============
		System.out.println("Has anything matching length > 5? "
				+ Stream.of("two", "three", "eighteen").anyMatch(s -> s.length() > 5));

		List<String> cookies = Arrays.asList("Peanut Butter Cookies", "Oatmeal-Raisin Cookies",
				"Basic Chocolate Chip Cookies");

		System.out.println("Do they all have cookies? " + cookies.stream().allMatch(p -> p.contains("Cookies")));
		System.out.println("Do none have banana? " + cookies.stream().noneMatch(p -> p.contains("Banana")));

		// ======= grouping =======
		// For more examples see
		// http://www.leveluplunch.com/java/examples/java-util-stream-groupingBy-example/

		List<StudentClass> studentClasses = new ArrayList<>();
		studentClasses.add(new StudentClass("Kumar", 101, "Intro to Web"));
		studentClasses.add(new StudentClass("White", 102, "Advanced Java"));
		studentClasses.add(new StudentClass("Kumar", 101, "Intro to Cobol"));
		studentClasses.add(new StudentClass("Sargent", 101, "Intro to Web"));
		studentClasses.add(new StudentClass("Sargent", 102, "Advanced Web"));

		Map<String, List<StudentClass>> groupByTeachers;
		groupByTeachers = studentClasses.stream()
				.collect(Collectors.groupingBy(StudentClass::getTutor));
		printCourses(groupByTeachers.get("White"));
		printCourses(groupByTeachers.get("Sargent"));
		printCourses(groupByTeachers.get("Kumar"));
		
		//====== RANGE ======
		//.boxed simply casts a primitive integers to an Integer
		Set<Integer> range = IntStream.range(1, 10).boxed()
	            .collect(Collectors.toSet());

	    System.out.println("Range defined as from 1 to 10 gives us 9 numbers " + range);
	    
	    Set<Integer> range2 = IntStream.rangeClosed(3, 10).boxed()
	            .collect(Collectors.toSet());

	    System.out.println("Range defined as from 3 to 10 closed gives means inclusive " + range2);
	    
//	    ======= FLATMAP ========
	    /*
	     * Flattens the input from collections of collections to a collection
	     */
	    List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
	            .flatMap(n -> n.stream())
	            .map(integer -> integer + 10)
	            .collect(Collectors.toList());
	    System.out.println("Stream of List<Integer> objects is flat mapped to stream of integers which is then collected into a list " + together);
	    
	    //===== TOKENIZING and DISTINCT ======
	    // filtering unique elements
	    List<Article> posts = createArticles();
	    
	    List<String> tags = posts
	            .stream()
	            .map(Article::getTags)
	            .flatMap(tag -> Arrays.stream(tag.split(","))
	            		.map(String::trim)
	                    .map(String::toLowerCase))
	            .distinct()
	            .collect(Collectors.toList());
	    System.out.println("The list of all tags used is " + tags);        
	}

	private static List<Article> createArticles() {
		List<Article> blogposts;
		blogposts = new ArrayList<>();
		blogposts.add(new Article("How to be slim", "health,lifestyle,weight", 1000));
		blogposts.add(new Article("Why are people so tired?", "health,lifestyle,sleep", 400));
		blogposts.add(new Article("Get fit in 10 mins a day", "health,Lifestyle,exercise", 1000));
		blogposts.add(new Article("Earwax for all", "medicine,health", 500));
		blogposts.add(new Article("That gut feeling", "medicine,Health,nutrition", 500));
		return blogposts;
		
	}

	public static void printCourses(List<StudentClass> classes) {
		classes.stream()
			.collect(Collectors.toSet())
			.forEach(sc -> System.out.println("COURSE: " + sc.getClassName() + " " + sc.getLevel() + " " + sc.getTutor()));
	}

	public static boolean isGreaterThan3(int a) {
		System.out.println("Is > 3 - " + a);
		return a > 3;
	}

	public static boolean isEven(int a) {
		System.out.println("Is even - " + a);
		return a % 2 == 0;
	}

	public static int doubleMe(int a) {
		System.out.println("Doubling - " + a);
		return a * 2;
	}
}