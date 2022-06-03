/**
Problem Description
Given an array, find a non-empty contiguous subarray with the largest sum.
*/

import java.io.*;
import java.util.Scanner;
public class  ContigiousSequence {
	public static  long contigiousSequence(int arr[] , int n) {

			long maxSum = Integer.MIN_VALUE;
			long maxIndex = 0;

			for (int i = 0; i < n; i++){
				maxIndex = maxIndex + (long)arr[i];

				if(maxSum  < maxIndex)
					maxSum = maxIndex;
				if(maxIndex < 0)
					maxIndex = 0;
			}

			return maxSum;

	}
	public static void  main (String args []) {

		Scanner sc =  new  Scanner (System.in);

		int n = sc.nextInt();
		int arr [] = new int[n + 5];
		for ( int i = 0 ; i < n; i++)
			arr[i] = sc.nextInt();

		long max = contigiousSequence(arr, n);
		System.out.println(max);

	}
}