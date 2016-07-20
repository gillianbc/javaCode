package factories;

public class FactoryDemo {
	public static void main(String[] args) {
		//So we never have to call "new" on a computer - we just tell the factory what sort of 
		//computer we want and it does all the hard work
		//This makes it very easy to add new types of computer. If we need to change the way PCs 
		//and Servers are made, we can do that without necessarily affecting the client code 
		//(i.e. this demo).  All the client code is aware of is the factory.
		AbstractComputer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		AbstractComputer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}

}
