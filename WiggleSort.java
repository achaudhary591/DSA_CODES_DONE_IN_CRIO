/**
Problem Description
Given an unsorted array, sort it in wave form. That is, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
*/

import java.util.*;


class WiggleSort{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        List<Integer>ans = wiggleSort(n,nums);
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

     static void swap(List<Integer> nums, int i , int j){

        int temp = nums.get(i);

        nums.set(i , nums.get(j));

        nums.set(j , temp);
    }

    static List<Integer> wiggleSort(int n, List<Integer>nums){

        for(int i = 0 ; i < n-1; i++){
            int current =nums.get(i);
            int next = nums.get(i+1);

            if(((i % 2 == 0) && (current > next)) || ((i % 2 != 0) && (current < next))){
                swap(nums , i , i+1);
            }
        }
        return nums;
    }  

}