/**
Problem Description
Given an array(need not be sorted), find the maximum possible sum using any k elements of the array.
*/

import java.util.*;

class MaximumKSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int queries[] = new int[q];

        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();

        }

        ArrayList<Long> res = maximumKSum(n, q, arr, queries);

        for (long j : res) {
            System.out.println(j);
        }

    }

    static ArrayList<Long> maximumKSum(int n, int q, int arr[], int queries[]) {

        ArrayList<Long> result = new ArrayList<Long>();

        for(int  i = 0; i < q; i++){
            result.add(maxSum(arr , n , queries[i]));
            
        }
        return result;
    }

    public static long maxSum(int arr[], int n, int k)
    {
        
        Arrays.sort(arr);

        long sum = 0;

        for(int i = n - 1; i >= n - k; i--){
            sum = sum + arr[i];
        }

        return sum;        
    }
}