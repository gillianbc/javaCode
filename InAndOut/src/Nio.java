import static java.lang.Math.*;

public class Nio
{
	
	public static void main (String[] args) {
		System.out.println("Rome wasn't built in a day");
		System.out.print("This");
		System.out.println(" is now");
		double aDub = 12 ;
				int result = 0;
		result = (int)rint(log10(aDub));
		switch (result) {
		case 2:
			System.out.println("The number is between 100 and 999");
			break;
		case 1:
			System.out.println("The number is between 0 and 99");
			break;
		default:
			System.out.println("The number is over 999");
			break;
		}
	}
}