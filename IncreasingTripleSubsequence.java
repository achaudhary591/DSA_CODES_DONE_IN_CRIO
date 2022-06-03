/*
Problem Description
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k

such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
*/

import java.util.*;


class IncreasingTripleSubsequence{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            int n = sc.nextInt();
            List<Integer>nums = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                nums.add(sc.nextInt());
            }
            String ans = increasingTripleSubsequence(n,nums);
            System.out.println(ans);
        }
    }

    static String increasingTripleSubsequence(int n,List<Integer>nums){

        if(nums == null || nums.size() < 3){
            return "false";
        }

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int num : nums){
            if(num < minOne){
                minOne = num;
            }

            if(num > minOne ){
                minTwo = Math.min(num , minTwo);
            }

            if(num > minTwo){
                return "true";
            }

        }
        return "false";
    }
}