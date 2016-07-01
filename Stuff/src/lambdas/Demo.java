package lambdas;

//Define an interface.  It has a single method signature.
interface Fishable {
	void doSomething();
}

interface Sayable {
	String saySomething();
}

class Runner {
	public void run(Fishable f) {
		System.out.println("I am a Runner. I will now call doSomething()");
		f.doSomething();
	}

	public void speak(Sayable s) {
		System.out.println("I am a Speaker. I will now call saySomething()");
		String txt = s.saySomething();
		System.out.println("Returned string was: " + txt);
	}
};

public class Demo {
	public static void main(String[] args) {
		Runner paula = new Runner();
		/*
		 * We want to pass paula a block of code to run. The stuff in brackets
		 * is what's known as an anonymous class i.e we define the class on the
		 * fly and it has no name. It implements the Fishable interface so it
		 * must have a doSomething() method This is what we had to do in
		 * pre-Java 8
		 */
		paula.run(new Fishable() {
			public void doSomething() {
				System.out.println("I am fishing in the lake");
			}
		});
		// So here, I can give it a different doSomething() method
		paula.run(new Fishable() {
			public void doSomething() {
				System.out.println("I am fishing in the river");
			}
		});
		// With lambdas, the syntax is simpler
		// The () represents the doSomething() method. It knows this is the
		// method I mean as the Fishable interface only has a single method - a
		// single method interface is known as a 'functional interface'
		paula.run(() -> System.out.println("I am fishing in the ocean with a lambda"));
		// The code that is run doesn't have to be a single line.
		// Just put it in a block
		paula.run(() -> {
			System.out.print("I am fishing on a boat");
			System.out.println("...and my boat is green");
		});

		// The interface method can have a return type
		paula.speak(() -> {
			System.out.println("I must return a string");
			return "Done";
		});
	}

}
