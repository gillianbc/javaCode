package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ForEachLoop {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		//old style for loop
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		//another old style for loop
		for (Integer val : numbers) {
			System.out.println(val);
		}
		
		//for loop using a lambda
		//(Integer val) declares the input parameters for the method we want to use
		numbers.forEach(
				(Integer val) -> System.out.println(val));
		//But wait!  numbers is a List<Integer> so it's obvious to java that Integer 
		//is the datatype
		numbers.forEach(
				(val) -> System.out.println(val));
		//In fact, java doesn't even need the param brackets as they're obvious too
		numbers.forEach(
				val -> System.out.println(val));
		//Above, we're simply passing val through unchanged to another method
		//So, the variable can be anonymous too
		numbers.forEach(System.out::println);
		//It doesn't have to be a simple print statement.  Here I am referring
		//to a static method that accepts an Integer
		// (this is 'method reference' - loads of examples on http://www.studytrails.com/java/java8/Java8_Lambdas_FunctionalProgramming.jsp
		numbers.forEach(ForEachLoop::increase);
	}
public static void increase(Integer a){
	a++;
	System.out.println("It is " + a);
}
}
