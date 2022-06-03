/**
Problem Description
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

import java.util.*;


class MaximumProductSubarray{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Vector<Integer> vec = new Vector<Integer>();
        for(int i=0;i<n;i++)
        	vec.add(sc.nextInt());
        System.out.println(maximumProductSubarray(vec));
    }

    private static long maximumProductSubarray(Vector<Integer> nums){

        int len = nums.size();

        long maxEnding = nums.get(0);

        long minEnding = nums.get(0);

        long maxSoFar = nums.get(0);

        for(int i = 1; i < len; i++){
            long temp = Math.max(nums.get(i) , Math.max(nums.get(i) * maxEnding , nums.get(i) * minEnding));
            minEnding = Math.min(nums.get(i) , Math.min(nums.get(i) * maxEnding , nums.get(i) * minEnding));
            maxEnding = temp;
            maxSoFar = Math.max(maxSoFar , maxEnding);
        }

        return maxSoFar;
    } 
}