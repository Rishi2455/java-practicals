import java.util.Scanner;
import java.lang.Math;

public class prac1_10
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter side 1:");
		float a = s.nextFloat();
		System.out.print("Enter side 2:");
		float b = s.nextFloat();
		System.out.print("Enter side 3:");
		float c = s.nextFloat();
		float ts = (a+b+c)/2;
		float area = (float)Math.sqrt((ts)*(ts-a)*(ts-b)*(ts-c));
		System.out.println("Area of triangle: "+area);
	}
}
		