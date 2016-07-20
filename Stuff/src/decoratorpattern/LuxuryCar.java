package decoratorpattern;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.println("   Adding leather seats to my Luxury Car.");
	}
}
