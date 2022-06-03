/*
Problem Description
Given a sorted array, remove all duplicates such that each element occurs at most once in the array. Return the length of the modified array.

Note : The input array should be modified in-place i.e. no extra memory should be allocated to any other array and the question should be solved by using O(1) memory.
*/

import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    
    // Implement your solution by completing the below function
    public int removeDuplicates(int[] nums) {
        
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
           
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        scanner.close();

        int result = new RemoveDuplicatesFromSortedArray().removeDuplicates(numbers);
        System.out.print(Integer.toString(result));
    }
}