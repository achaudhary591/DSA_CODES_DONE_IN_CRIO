/**
Problem Description
Given an array *nums*, find all unique triplets (group of 3 numbers) such that their sum is 0. There should be no duplicates i.e. no triplet should be repeated.

Input format
The first line consists of an integer, N, denoting the size of the array.

The second line consists of N space separated integers which denote the elements of the array, nums.
*/

import java.util.Scanner;
import java.util.*;

class ThreeSum {
    
    public List<List<Integer>> threeSum(Integer[] nums) {
        boolean found = false;
        List<Integer> triples = null;
        HashSet<Integer> set = null;
        HashSet<List<Integer>> tripleSet = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {         
            set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                found = false;
                int x = -(nums[i] + nums[j]);
                if (set.contains(x)) {
                    Integer [] temp = {x,nums[i],nums[j]};
                    Arrays.sort(temp);
                    triples = new ArrayList<Integer>();
                    triples.add(temp[0]);
                    triples.add(temp[1]);
                    triples.add(temp[2]);
                    found = true;
                } else {
                    set.add(nums[j]);
                }
                
                if(found==true){
                    tripleSet.add(triples);

                }
                
            }
        }
        return new ArrayList<List<Integer>>(tripleSet);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer nums[] = new Integer[n];
        for(Integer i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d %d %d\n", result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
    }
};
