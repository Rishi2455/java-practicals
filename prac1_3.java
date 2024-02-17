import java.util.Scanner;

public class prac1_3
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("standard form of equations are: ");
		System.out.println("ax + by = e and cx + dy = f");
		System.out.println("!!Enter input accordingly!!");
		System.out.print("Enter value of a:");
		float a = s.nextFloat();
		System.out.print("Enter value of b:");
		float b = s.nextFloat();
		System.out.print("Enter value of e:");
		float e = s.nextFloat();

		System.out.print("Enter value of c:");
		float c = s.nextFloat();
		System.out.print("Enter value of d:");
		float d = s.nextFloat();
		System.out.print("Enter value of f:");
		float f = s.nextFloat();

		float x = (e*d-b*f)/(a*d-b*c);
		float y = (a*f-e*c)/(a*d-b*c);

		System.out.println("\n---->x = "+ x + ", y = "+ y);
	}
}