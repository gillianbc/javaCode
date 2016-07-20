package decoratorpattern;

public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.println("   Adding go faster stripes to my Sports Car.");
	}
}
