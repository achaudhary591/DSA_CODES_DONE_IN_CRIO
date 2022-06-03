/**
Problem Description
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

import java.util.*;


class MinimumSizeSubarraySum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,t;
        n=sc.nextInt();
        t=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(minimumSizeSubarraySum(t,arr));
    }

    static int minimumSizeSubarraySum(int target, int arr[]){

        int len = arr.length;
        int lenOfMinimumArray = Integer.MAX_VALUE;

        int winSum = 0;
        int winStart = 0;

        for(int winEnd = 0; winEnd < len; winEnd++){
            winSum += arr[winEnd];

            while(winSum >= target){
                lenOfMinimumArray = Math.min(lenOfMinimumArray , winEnd-winStart+1);
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return lenOfMinimumArray == Integer.MAX_VALUE ? 0 : lenOfMinimumArray;
    }
}