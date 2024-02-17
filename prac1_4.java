import java.util.Scanner;

public class prac1_4
{
	public static void main(String args[])
	{
		System.out.print("Enter lenght into meter:");
		Scanner s = new Scanner(System.in);
		float m = s.nextFloat();
		float f = (3.28f * m);
		System.out.println("Length in feet: "+ f);
	}
}
				