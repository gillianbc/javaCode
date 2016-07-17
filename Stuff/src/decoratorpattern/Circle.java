package decoratorpattern;

public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println(this.getClass().getName() + " drawn");
		
	}

}
