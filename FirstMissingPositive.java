/*Problem Description
Given an unsorted array of integers, find the smallest missing positive integer. The space complexity need not be O(1), you can also implement a O(N) space complexity solution.

Input format
There are 2 lines of input.

First line contains 1 integer N - Number of elements in the array.

Second line contains space separated N integers.*/

import java.util.*;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        boolean[] isPresent = new boolean[len + 1];

        for (int n : nums) {

            if (n >= 0 && n <= len) {
                isPresent[n] = true;
            }
        }

        for (int i = 1; i < isPresent.length; i++) {
            if (!isPresent[i])
                return i;
        }

        return len + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = in.nextInt();
        }
        int result = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(result);
    }
}