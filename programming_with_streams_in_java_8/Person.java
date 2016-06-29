public class Person {
	private String name;
	private Gender gender;
	private Integer age;

	public Person(String name, Gender sex, Integer age) {
		super();
		this.name = name;
		this.gender = sex;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender sex) {
		this.gender = sex;
	}

	@Override
	public String toString() {
		return "Name: " + name + " age " + age + " gender " + gender;

	}
}
