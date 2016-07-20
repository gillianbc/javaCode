package decoratorpattern;
/*
 * This is the COMPONENT class.  All cars have these common features
 */
public class BasicCar implements Car {

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		System.out.println("Basic Car component assembled.");
	}

}
