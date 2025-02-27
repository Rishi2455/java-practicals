import java.util.Scanner;

public class prac1_8
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter amount: ");
		int a = s.nextInt();
		int n100 = a/100;
		int n50 = (a%100)/50;
		int n10 = ((a%100)%50)/10;
		int n5 = (((a%100)%50)%10)/5;
		int n2 = ((((a%100)%50)%10)%5)/2;
		int n1 = ((((a%100)%50)%10)%5)%2;
		System.out.println("||No. of currency note:||");
		System.out.println("100:"+n100);
		System.out.println("50 :"+n50);
		System.out.println("10 :"+n10);
		System.out.println("5  :"+n5);
		System.out.println("2  :"+n2);
		System.out.println("1  :"+n1);
	}
}
		
