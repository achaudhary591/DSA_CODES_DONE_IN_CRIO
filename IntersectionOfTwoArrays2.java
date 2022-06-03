/*
Problem Description
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Input format
The first line contains two integers N and M, the sizes of the two arrays. The second line contains the N elements belonging to the array nums1. The third line contains the M elements belonging to the array nums2.
*/

import java.util.*;


class IntersectionOfTwoArrays2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr1[]=new int[n];
        int arr2[]=new int[m];

        for(int i=0;i<n;i++)
        {
            arr1[i]=sc.nextInt();
        }

        for(int i=0;i<m;i++)
        {
            arr2[i]=sc.nextInt();
        }
        int ans[]=intersectionOfTwoArrays2(arr1,arr2);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    static int[] intersectionOfTwoArrays2(int arr1[], int arr2[]){

        if(arr1.length > arr2.length){
            return intersectionOfTwoArrays2(arr2 , arr1);
        }

        Map<Integer , Integer> map = new HashMap<Integer , Integer>();

        for(int value : arr1){
            map.put(value , map.getOrDefault(value , 0)+1);
        }

        int k = 0;

        for(int value : arr2){
            if(map.getOrDefault(value , 0) > 0){
                arr1[k++] = value;
                map.put(value , map.get(value)-1);
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = arr1[i];
        }

        return result;
    }
}
