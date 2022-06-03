/**
Problem Description
Given an array, find the length of the shortest subarray in it, sorting which will sort the whole array. This should be achieved with O(1) space.
*/

import java.io.*;
import java.util.*;

//using STACK

class ShortestUnsortedContinuousSubarray {
    
    // Complete the function implementation below
    public int findUnsortedSubarrayLength(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new ShortestUnsortedContinuousSubarray().findUnsortedSubarrayLength(nums);
        System.out.println(result);
    }
}

/**.......................................
USING SORTING

int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);

 Time complexity : O(n\log n)O(nlogn). Sorting takes n\log nnlogn time.

Space complexity : O(n)O(n). We are making copy of original array.

*/


/** ............................................

 without USING ANY EXTRA SPACE

 int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;

        Time complexity : O(n)O(n). Four O(n)O(n) loops are used.

Space complexity : O(1)O(1). Constant space is used.
   
 */

/**
 * 
 * */