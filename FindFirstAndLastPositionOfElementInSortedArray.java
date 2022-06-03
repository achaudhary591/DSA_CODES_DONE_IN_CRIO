/**
Problem Description
Given an array of integers of length n sorted in ascending order and Q number of queries, for each query you have to find the first and last position (0-based indexed) of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
*/

import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    
    public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        int[] answer = new int[2];

        int len = nums.length;

        answer[0] = first(nums , target , len);
        answer[1] = last(nums , target , len);
        return answer;
    }

    static int first(int arr[], int x, int n){
        int low = 0, high = n - 1, res = -1;
        
        while (low <= high)
        {   
            int mid = (low + high) / 2;
            
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1; 
    
            else
            {
                res = mid;
                high = mid - 1;
            }
        }
    return res;
    }

    static int last(int arr[], int x, int n)
    {
        int low = 0, high = n - 1,
        res = -1;
  
        while (low <= high)
        {
    
            int mid = (low + high) / 2;
            
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
     
            else
            {
                res = mid;
                low = mid + 1;
            }
        }
    return res;
    }
}