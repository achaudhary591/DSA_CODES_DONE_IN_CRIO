/**
Problem Description
Given an array of non negative integers, arrange the elements, such that if made into a number, they form the largest number.
*/

import java.util.*;
import java.util.Scanner;

class LargestNumber {
    public String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>(nums.length);
        for(int num : nums){
            list.add(String.valueOf(num));
        }
        Collections.sort(list , (o1 , o2) -> (o2 + o1).compareTo(o1 + o2));

        return String.join("" , list);
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        String result = new LargestNumber().largestNumber(nums);

        System.out.println(result);
    }

}