import java.util.Scanner;

public class prac1_9
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a five digit number: ");
		int n = s.nextInt();
		System.out.println("New number: "+(n+11111));
	}
}
