/**
Problem Description
Given two numbers, write a program to count the number of bits that need to be flipped to convert the first number to the second number.
*/

import java.util.*;

class Conversion{
	public static int conversion(long A,long B)
	{
		long result = A ^ B;

		return countNoOfOnes(result);
	}

	public static int countNoOfOnes(long n){

		int count = 0;
		
		while(n != 0){

			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		System.out.println(conversion(a,b));
	}	
}