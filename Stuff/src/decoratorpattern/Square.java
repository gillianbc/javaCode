package decoratorpattern;

public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println(this.getClass().getName() + " drawn");
		
	}

}
