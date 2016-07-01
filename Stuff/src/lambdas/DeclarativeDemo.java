package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeclarativeDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 8);
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
				.map(e -> e * 2).findFirst());
		

		System.out.println(numbers.stream()
				.filter(DeclarativeDemo::isGreaterThan3)
				.filter(DeclarativeDemo::isEven)
				.map(DeclarativeDemo::doubleMe)
				.findFirst()
				);
	}
	public static boolean isGreaterThan3(int a){
		System.out.println("Is > 3 - " + a);
		return a > 3;
	}
	public static boolean isEven(int a){
		System.out.println("Is even - " + a);
		return a % 2 ==0;
	}
	public static int doubleMe(int a){
		System.out.println("Doubling - " + a);
		return a * 2;
	}
}