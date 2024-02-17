import java.util.Scanner;

public class prac1_7
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a character: ");
		char c = s.next().charAt(0);
		if((c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u'))
		{
			System.out.println("Entered letter is a vowel");
		}
		else
		{
			System.out.println("Entered letter is a consonent");
		}
	}
}