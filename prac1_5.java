import java.util.Scanner;

public class prac1_5
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter weight into pounds:");		
		float w = s.nextFloat();
		System.out.print("Enter height into inches:");
		float h = s.nextFloat();
		w = w * 0.4535f;
		h = h * 0.254f;
		System.out.println("Your BMI is: "+ w/(h*h));
	}
}
				