
/*
 * See http://www.agiledeveloper.com/downloads.html
 * Watch https://www.youtube.com/watch?v=rVfRDLIw_Zw&list=PLPIzp-E1msrZbuE1BW0xxYCNBtLkoUHfO&index=20
 */

import java.util.*;

import static java.util.stream.Collectors.*;

public class Sample {

	public static List<Person> createPeople() {
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20), new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20), new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32), new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72), new Person("Jill", Gender.FEMALE, 12));
	}

	public static void main(String[] args) {
		List<Person> people = createPeople();

		// get, in uppercase, the names of all female older than 18
		List<String> names = new ArrayList<>();
		for (Person person : people) {
			if (person.getGender() == Gender.FEMALE && person.getAge() > 18) {
				names.add(person.getName().toUpperCase());
			}
		}

		System.out.println(names);

		// The above mixes what with how - sequential, one element at a time.
		// Details all thrown together.
		// imperative in nature - mutability and low level details
		// We are focused on each element

		// Let's use Streams instead
		// The filter commands still give you a stream of Person objects
		// The 'map' commands are operations on an item in the stream
		// e.g. person.getName() gives you a String
		System.out.println("Using a stream " + 
				people.stream()
		        .filter(person -> person.getGender() == Gender.FEMALE)
				.filter(person -> person.getAge() > 18)
				.map(person -> person.getName())
				.map(named -> named.toUpperCase())
				.collect(toList()));
		// Using streams again, but using the class method reference syntax
		System.out.println("Using a stream and method references" + people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.filter(person -> person.getAge() > 18)
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(toList()));
		/*
		 *  RAISE to abstract i.e. stream
		 *  OPERATE - Ride the stream - i.e. filter and map (but don't mutate it)
		 *  LAND - Reduce back to concrete e.g. collect(toList)
		 *  
		 *  the filtering amd mapping are INTERMEDIATE operations as we're flying through the stream
		 *  we land back on the concrete with a TERMINAL operation
		 *  The intermediate operations don't happen unless there's a terminal operation - he is the boss.
		 *  No-one bothers doing any work if the boss isn't there
		 */

		// we said what, not how, may be sequential, lazy, parallel, etc.
		// functional and declarative in nature - no explicit mutation and
		// higher level of abstraction
		// focus on the whole collection instead of fiddling with iteration and
		// each element.
		// Don't be dirty and mutate the stream. If you need to change what' in
		// the
		// collection, do it outside of the stream

		// get the total age of all the women
		/*
		 * reduce - pass a postIt note around all the people and get them to add
		 * their age to the running total The first postIt has a 0 on it -
		 * that's the starting point The age is the result of the previous line
		 * i.e. getAge()
		 * 
		 * .reduce:  0 is the starting point;  the initial value
		 * 	ACCUMULATOR:  an associative operation to apply to 2 instances in the stream
		 */
		System.out.println("Total age of women " 
				+ people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.map(Person::getAge)
				.reduce(0, (x, y) -> x + y));  //given the age of two persons, add them
		
		//Here's how we'd do a sum of numbers
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		System.out.println("Sum of numbers is " +
				numbers.stream()
				.reduce(0,(x,y) -> x + y));
		//Here's how we'd do n! - note that start point is 1
		System.out.println("Factorial of numbers is " +
				numbers.stream()
				.reduce(1,(x,y) -> x * y));
		
		//Here's how we'd do a sum of even numbers
				System.out.println("Sum of even numbers is " +
				numbers.stream()
				.filter(a -> a % 2 == 0)
				.reduce(0,(x,y) -> x + y));
		//Here's how we'd do a sum of odd numbers
		System.out.println("Sum of odd numbers is " +
		numbers.stream()
		.filter(a -> a % 2 == 1)
		.reduce(0,(x,y) -> x + y));
		/*
		 * map(Person::getAge) results in a collection of Integers, but we
		 * cannot call sum() which is the usual way of summing a collection of
		 * numerics. To make the base class methods available, we use mapToInt
		 * which gives us an IntStream 
		 * 
		 * Intermediate operations return a new
		 * stream. They are always lazy.
		 * Executing an intermediate operation
		 * such as filter() does not actually perform any filtering, but instead
		 * creates a new stream that, when traversed, contains the elements of
		 * the initial stream that match the given predicate. Traversal of the
		 * pipeline source does not begin until the terminal operation of the
		 * pipeline is executed.
		 * 
		 * Terminal operations, such as Stream.forEach or IntStream.sum, may
		 * traverse the stream to produce a result or a side-effect. After the
		 * terminal operation is performed, the stream pipeline is considered
		 * consumed, and can no longer be used; if you need to traverse the same
		 * data source again, you must return to the data source to get a new
		 * stream. In almost all cases, terminal operations are eager,
		 * completing their traversal of the data source and processing of the
		 * pipeline before returning. Only the terminal operations iterator()
		 * and spliterator() are not; these are provided as an "escape hatch" to
		 * enable arbitrary client-controlled pipeline traversals in the event
		 * that the existing operations are not sufficient to the task.
		 * 
		 * 
		 * sum() is an operation on the whole collection i.e. it reduces
		 * We're now going from the abstraction of a stream back to a concrete class
		 */
		System.out.println("Total age of women using sum()"
				+ people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.mapToInt(Person::getAge)
				.sum());
		// To get the oldest person, we have to define a comparator on age
		System.out.println("Oldest woman "
				+ people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.max((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1));
		
		System.out.println("Count of females under 18 is "
				+ people.stream()
				.filter(person -> person.getGender() == Gender.FEMALE)
				.filter(person -> person.getAge() < 18)
				.count());
		
		/* More about mutating a what Dr Venkat calls 'evil code' and UNHYGIENIC.  Here we're getting
		 * a list of the persons older than 17 and showing their uppercase name
		 * It's evil because we're modifying list namesUpper WITHIN the stream when it
		 * was declared OUTSIDE of the stream
		 */
		List<String> namesUpper = new ArrayList<>();
		people.stream()
			.filter(person -> person.getAge() > 17)
			.map(adult -> adult.getName().toUpperCase())
			.forEach(name -> namesUpper.add(name));
		
		/*
		 * SUPPLIER, ACCUMULATOR, COMBINER
		 * 
		 * This is what we should have done - used collect to land back on a
		 * concrete class.  This is threadsafe as the temporary variables have been created 
		 * within our stream operations.  collect needs a supplier, an accumulator and a combiner
		 * SUPPLIER - the blank postIt note that we start with;  in this case, an ArrayList
		 * ACCUMULATOR - where we choose the ArrayList operation that will do the accumulation 
		 * COMBINER - is the ArrayList operation that would combine two instances together
		 * i.e. if we were using a different collection instead of ArrayList, we'd have
		 * different operations
		 */
		List<String> namesUpper2 = new ArrayList<String>();
		namesUpper2 = people.stream()
			.filter(person -> person.getAge() > 17)
			.map(adult -> adult.getName().toUpperCase())
			.collect(() -> new ArrayList<String>(),
			(list, name) -> list.add(name),
			(list1, list2) -> list1.addAll(list2));
		System.out.println(namesUpper2);
		//Fortunately, java gives us a built in method to avoid all this, toList()
		namesUpper2 = people.stream()
				.filter(person -> person.getAge() > 17)
				.map(adult -> adult.getName().toUpperCase())
				.collect(toList());
		System.out.println(namesUpper2);
		
		// There are other methods if you want a set rather than a list i.e. no duplicate values
		Set<String> maleNames = people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.map(Person::getName)
				.collect(toSet());
		System.out.println("male names set " + maleNames);
		//We can even get a hash map (a keyed set) out of the stream.  We'll need operations to define
		//the unique key and the element i.e. key is combo person's name and age (there are 2 Jacks) and the
		//element is the whole person
		Map<String, Person> map = people.stream()
				.collect(toMap(
						person -> person.getName() + "_" + person.getAge(),
						person -> person));
		System.out.println("keyed persons is: " + map);
	}

}
