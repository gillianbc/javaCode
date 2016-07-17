package decoratorpattern;

public abstract class AbstractShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public AbstractShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}
