package decoratorpattern;

public class DecoratorDemo {

	public static void main(String[] args) {
		Car mycar = new FamilyCar(new SportsCar(new LuxuryCar(new BasicCar())));
		mycar.assemble();
	}

}
