package lambdas;

public class StudentClass{
	private String tutor;
	private double level;
	private String className;
	
	StudentClass(String tutor, double level, String className){
		this.tutor = tutor;
		this.level = level;
		this.className = className;
	}

	public String getTutor() {
		return tutor;
	}

	public double getLevel() {
		return level;
	}

	public String getClassName() {
		return className;
	}
	
}
