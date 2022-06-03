/*
Problem Description
Given an array of integers as input, output the indices of two numbers in the array which add up to a specified target.

Assume that each input would have exactly one solution and you cannot use the same element twice. If 2 different elements have the same value, they can be used.

Print the indices in increasing order.

Input format
First line contains an Integer N that represents the number of elements in the array.

Second line contains N space separated integers, which are members of the array.

Third line contains an integer X, which is the target value.
*/

import java.io.*;
import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
 
        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
            // check if pair (nums[i], target-nums[i]) exists
 
            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
                result[1] = i;
                result[0] =map.get(target - nums[i]);
                break;
            }
 
            // store index of the current element in the map
            map.put(nums[i], i);
        }
 
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSum().twoSum(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}