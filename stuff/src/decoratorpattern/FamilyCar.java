package decoratorpattern;

public class FamilyCar extends CarDecorator {

	public FamilyCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.println("   Adding child seats to my Family Car.");
	}
}
