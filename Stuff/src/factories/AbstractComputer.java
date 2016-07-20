package factories;
/*
 * The super class in the factory design pattern can be an interface, abstract 
 * class or a normal java class. For our factory design pattern example, we have 
 * an abstract super class with an overridden toString() method for testing purposes.
 */
public abstract class AbstractComputer {
	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString(){
		return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
	}
}
