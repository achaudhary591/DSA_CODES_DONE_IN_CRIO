/**
Problem Description
Given an array in which all numbers except two are repeated once. (i.e. we have 2k+2 numbers and k numbers are occurring twice and remaining two have occurred once).

Find those two numbers in the most efficient way. Return the two numbers in a sorted manner.
*/

import java.util.*;

class TwoNonRepeatingNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int ans[] = twoNonRepeatingNumbers(nums);
        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }

    static int[] twoNonRepeatingNumbers(int[] nums) {

        int[] ans = new int[2];
        int xor = nums[0];

        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        int rightMostSetBit = xor & ~ (xor - 1);

        int a = 0 , b = 0;
        for(int i = 0; i < nums.length; i++){

            int x = nums[i];
            if((x & rightMostSetBit) != 0){
                a ^= x;
            }
            else{
                b ^= x;
            }            
        }
        ans[0] = a;
        ans[1] = b;
        Arrays.sort(ans);
        return ans;
    }
}