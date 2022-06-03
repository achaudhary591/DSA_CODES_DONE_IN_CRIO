/**
Problem Description
Given an array A having N elements, the task is to find the next greater element(NGE) for each element of the array in order of their appearance in the array. If no such element exists, output -1. This should be achieved with a time complexity of O(n).
*/

import java.util.*;
class NextLargerElementUsingStack {

	static int [] nextLargerElement(int nums[], int n) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[n];

		for(int i = n - 1; i >= 0; i--){

			while(!stack.isEmpty() && stack.peek() <= nums[i]){

				stack.pop();
			}

			if(stack.empty())
				arr[i] = -1;
			else
				arr[i] = stack.peek();
			
			stack.push(nums[i]);			
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int [] ans = nextLargerElement(ar, n);
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
	}
}