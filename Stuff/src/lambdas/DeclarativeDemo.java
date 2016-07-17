package lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DeclarativeDemo {

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
		System.out.println(numbers.stream()
				.filter(e -> e > 3)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2).findFirst());

		/*
		 * but what about performance? Using the old fashioned imperative method
		 * performs 8 operations before it returns us the result. If we use
		 * method calls in the declarative lambda style loop, we'll see that it
		 * still only uses 8 operations. The findFirst prevents it from checking
		 * subsequent numbers in the list
		 */
		System.out.println(numbers.stream()
				.filter(e -> e > 3)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.findFirst());

		/*
		 * You can also use method calls for the filtering and mapping
		 */
		System.out.println(numbers.stream()
				.filter(DeclarativeDemo::isGreaterThan3)
				.filter(DeclarativeDemo::isEven)
				.map(DeclarativeDemo::doubleMe)
				.findFirst());

		/*
		 * Print out the numbers that are duplicates i.e. 
		 * occur more than once in the stream
		 */
		System.out.println("Duplicates are:");
		numbers.stream()
			.filter(i -> Collections.frequency(numbers, i) > 1)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		//Same as above but a different way of printing out
		numbers.stream()
		.filter(i -> Collections.frequency(numbers, i) > 1)
		.collect(Collectors.toSet())
		.forEach(p -> System.out.println("Duplicated: " + p));
		
		//Simple boolean condition - has duplicates?
		if (numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1).count() > 0)
			System.out.println("Has duplicates");
		
		//Also see: http://www.leveluplunch.com/java/examples/stream-terminal-operations-example/
		//================== REDUCE ===================================================
		//Sum of all numbers in stream
		System.out.println("Sum of all numbers: " +
		numbers.stream()
		.reduce(0,(a,b) -> a + b));
		
		int sum = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
		System.out.println("Sum is " + sum);
		
		System.out.println("Product of all even numbers: " +
				numbers.stream()
				.filter(e -> e % 2 == 0)
				.reduce(0,(a,b) -> a + b));
		//================ TOARRAY =====================================================
		
		Object[] objArray = numbers.stream()
				.filter(e -> e % 2 == 0)
				.toArray();
		System.out.println("Objarray length is: " + objArray.length);
		
		//============ STREAM OF ======= FOREACH =====================
		Stream.of("Hello", "World").forEach(p -> System.out.print(p.length() + " - "));
		System.out.println();
		//===== MIN ======  MAX ===== MAPTODOUBLE ======
		System.out.println("Minimum " + IntStream.of(1, 2, 3).min());
		//convert the optional to an int
		System.out.println("Minimum " + IntStream.of(1, 2, 3).min().getAsInt());
		
		System.out.println(Stream.of(1d, 2d, 3d)
	            .mapToDouble(Double::doubleValue).max());
		
		//=========ALLMATCH NONEMATCH ANYMATCH =============
		System.out.println("Has anything matching length > 5? " + Stream.of("two", "three", "eighteen").anyMatch(s -> s.length() > 5));
		
		List<String> cookies = Arrays.asList("Peanut Butter Cookies",
	            "Oatmeal-Raisin Cookies", "Basic Chocolate Chip Cookies");

	    System.out.println("Do they all have cookies? " + cookies.stream().allMatch(
	            p -> p.contains("Cookies")));
	    System.out.println("Do none have banana? " + cookies.stream().noneMatch(
	            p -> p.contains("Banana")));
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