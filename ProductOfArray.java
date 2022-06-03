/**
Problem Description
Given an array nums of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
*/

import java.util.*;


class ProductOfArray{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        List<Integer> result = productOfArray(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(result.get(i)+" ");
        }
    }

    static List<Integer> productOfArray(List<Integer>nums){

        int i=0;
        int j=nums.size();
        int p=1,f=1,c=0,k=0;
        
        while(i!=j)
        {
            p*=nums.get(i);
            if(nums.get(i)==0)
            {
               c++;
                k=i;
            }
            i++;
        }
       
        i=0;
        
        if(c>1)
        {
            while(i!=j)
        {
            nums.set(i , 0);
            i++;
        }
            
        }
        else if(c==1)
        {
            i=0;
            p=1;
            while(i!=j)
            {
                if(i!=k)
                    p = p*nums.get(i);
                i++;
            }
            i=0;
            while(i!=j)
            {
                if(i==k)
                    nums.set(i , p);
                else
                    nums.set(i , 0);
                i++;
            }
        }
        else
        {
            i=0;
            while(i!=j)
            {
                nums.set(i , p/nums.get(i));
                i++;
            }
        }
        return nums;
    }
}