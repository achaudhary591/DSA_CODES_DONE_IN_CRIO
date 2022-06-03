/*
Problem Description
Given two sorted arrays of size M and N, merge the two arrays and return the final array, sorted.
*/

import java.io.*;
import java.util.*;

public class MergeSortedArray {
    // Implement your solution by completing the below function
    public static int [] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int first = 0, second=0;
        int[] result = new int[n+m];
        int k = 0;

        while(first < m && second < n ){
            
            if(nums1[first] <= nums2[second]){
                result[k++] = nums1[first++];
            }
            else{
                result[k++] = nums2[second++];
            }            
        }
        
        while(first < m){
            result[k++] = nums1[first++];
        }
        
        while(second < n){
            result[k++] = nums2[second++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++)
            nums1[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            nums2[i] = scanner.nextInt();

        scanner.close();

        int[] nums = mergeSortedArray(nums1, m, nums2, n);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}