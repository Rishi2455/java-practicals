import java.util.Scanner;

public class prac1_6
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int n1 = s.nextInt();
		System.out.print("Enter number 2: ");
		int n2 = s.nextInt();
		System.out.print("Enter number 3: ");
		int n3 = s.nextInt();
		int max;
		if(n1>n2 && n1>n3)
		{
			max = n1;
		}
		else if(n2>n1 && n2>n3)
		{
			max = n2;
		}
		else
		{
			max = n3;
		}

		int min;
		if(n1<n2 && n1<n3)
		{
			min = n1;
		}
		else if(n2<n1 && n2<n3)
		{
			min = n2;
		}
		else
		{
			min = n3;
		}

		int smax;
		if(n1>n2 && n1<n3)		
		{
			smax = n1;
		}
		else if(n2>n1 && n2<n3)		
		{
			smax = n2;
		}
		else
		{
			smax = n3;
		}
		
		System.out.println("Desc Order: "+max+" "+smax+" "+min);
	}
}