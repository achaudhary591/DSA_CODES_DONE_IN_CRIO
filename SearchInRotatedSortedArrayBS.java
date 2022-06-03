/**
Problem Description
An array sorted in ascending order is rotated about a pivot unknown to you. Such an array is referred to as a rotated sorted array or a sorted-pivoted array. For example : [1,2,3,4,5] is a sorted array while [3,4,5,1,2] is a rotated sorted array.


You are given a rotated sorted array, and some integer values. You have to find each value’s location in the array. If the value is present, return the index in which it is stored ( 0 based indexing) , otherwise if not found return -1.


Assume the array doesn’t have duplicates.
*/


import java.io.*;
import java.util.*;
class SearchInRotatedSortedArrayBS {

    // Complete the function implementation below
    public int search(int[] nums, int target) {

        int left = 0;
        int right= nums.length-1;
 
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;
 
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }    
        }
 
        return -1;
    }

    /** RECURSIVE APPROACH
      public int search(int[] nums, int target) {
   		return binarySearch(nums, 0, nums.length-1, target);
	  }
 
	public int binarySearch(int[] nums, int left, int right, int target){
    	if(left>right) 
        	return -1;
 
    	int mid = left + (right-left)/2;
 
    	if(target == nums[mid])
        	return mid;
 
    	if(nums[left] <= nums[mid]){
        	if(nums[left]<=target && target<nums[mid]){
          		return binarySearch(nums,left, mid-1, target);
        	}else{
          		return  binarySearch(nums, mid+1, right, target);
        	}
    	}else {
        	if(nums[mid]<target&& target<=nums[right]){
          		return  binarySearch(nums,mid+1, right, target);
        	}else{
          		return  binarySearch(nums, left, mid-1, target);
        	}
    	}
	}
	*/

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInRotatedSortedArray().search(nums , target);
            System.out.println(result);
            q--;
        }
    }
}