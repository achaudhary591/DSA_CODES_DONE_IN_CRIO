/**
Problem Description
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/

import java.util.*;


class SingleMissingNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(singleMissingNumber(nums, n));
        sc.close();
    }

    static int singleMissingNumber(int[] nums, int n){

        // int missing = n;
                
        // for (int i = 0; i < nums.length; i++) {
        //     missing ^= i ^ nums[i];
        // }
        // return missing;

        Arrays.sort(nums);
        
        int l = 0, r = n;
   
        while(l < r){
            int m = (l + r) / 2;
            
            if(nums[m] > m){
                r=m;
            }else{
                l = m + 1;
            }
        } 
        return r;
    }   
       
}