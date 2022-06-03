/*
Problem Description
Given an array nums, you need to find the maximum sum of triplet (nums[i] + nums[j] + nums[k]) such that 0 <= i < j < k and nums[i] < nums[j] < nums[k]. If no such triplet exists print 0.
*/

import java.util.*;

class MaxSumTriplet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = maxSumTriplet(n, arr);

            System.out.println(result);

        }

    }

    static long maxSumTriplet(int n, long arr[]) {
        long ans = 0;
 
        for (int i = 1; i < n - 1; ++i) {
            long max1 = 0, max2 = 0;
 
            // find maximum value(less than arr[i])
            // from 0 to i-1
            for (int j = 0; j < i; ++j)
                if (arr[j] < arr[i])
                    max1 = (long)Math.max(max1, arr[j]);
 
            // find maximum value(greater than arr[i])
            // from i+1 to n-1
            for (int j = i + 1; j < n; ++j)
                if (arr[j] > arr[i])
                    max2 = (long)Math.max(max2, arr[j]);
 
            // store maximum answer
        if(max1 > 0 && max2 > 0)
            ans = (long)Math.max(ans, max1 + arr[i] + max2);
        }
 
        return ans;
    }
}