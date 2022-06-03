/**
Problem Description
Given an array of integers and a number k, find the maximum sum of a subarray of size k.
*/

import java.util.*;

class MaximumSubarraySumSizeK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumSubarraySumSizeK(arr, n, k));
        sc.close();
    }

    static int maximumSubarraySumSizeK(int[] arr, int n, int k) {
//Declare a variable and assigned value 0
     if (n < k)
        {
           
           return -1;
        }
      
        
        int res = 0;
        for (int i=0; i<k; i++)
           res += arr[i];
      
        
        int curr_sum = res;
        for (int i=k; i<n; i++)
        {
           curr_sum += arr[i] - arr[i-k];
           res = Math.max(res, curr_sum);
        }
      
        return res;
    }
}