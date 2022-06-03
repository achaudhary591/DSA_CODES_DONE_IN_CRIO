/**
Problem Description
A peak element is an element that is strictly greater than its neighbors. Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks. You may imagine that nums[-1] = nums[n] = -∞. You must write an algorithm that runs in O(log n) time.

Input format
The first line contains an integer N, the size of the input array. The second line contains N integers, the elements of the given array.
*/

import java.util.*;


class PeakElementBS{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(peakElement(arr));
    }

    static int peakElement(int arr[]){

        int left = 0, n = arr.length, right = n - 1;
        
        if(n == 1) return left;
        
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > arr[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
       
}