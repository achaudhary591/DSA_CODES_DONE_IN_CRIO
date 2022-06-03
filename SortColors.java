/*
Problem Description
Given an array with n objects colored red, white or blue,

sort them in-place so that objects of the same color are adjacent,

with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not supposed to use the library's sort function for this problem.
*/

import java.io.*;
import java.util.*;

class SortColors {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int pos0 = 0;
        int pos1 = n - 1;
        int pos2 = n - 1;
        while (pos0 < pos2) {
            if (nums[pos0] == 0)
                pos0++;
            else if (nums[pos0] == 1) {
                if (pos0 < pos1) {
                    int temp = nums[pos0];
                    nums[pos0] = nums[pos1];
                    nums[pos1] = temp;
                    pos1--;
                }
                else
                    pos0++;
            }
            else {
                int temp = nums[pos0];
                nums[pos0] = nums[pos2];
                nums[pos2] = temp;
                pos2--;
                if (pos1 > pos2)
                    pos1 = pos2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        scanner.close();

        SortColors result = new SortColors();
        result.sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
    }
}