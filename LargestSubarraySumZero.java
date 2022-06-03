/**
Problem Description
Given an integer array, find the largest subarray with sum 0 . If there is more than one subarray with the largest length, return the subarray with the lowest starting index.

If there is no such sub-array print -1.
*/

import java.util.*;

class LargestSubarraySumZero {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = largestSubarraySumZero(n, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {

    Map<Integer,Integer> map = new HashMap<>();
      ArrayList<Integer> list=new ArrayList<>();;     
        map.put(0,-1);
    int sum =0,maxi=0, st=0;
        for(int i=0; i< arr.length; i++){
            sum += arr[i];
            if(sum == 0) {
                maxi = i + 1; 
            }
            else{
            if(map.get(sum)!=null){
                if(maxi <= i- map.get(sum)){
                    maxi =Math.max( maxi,i-map.get(sum));
                    st = map.get(sum)+1;
                }
            }
            else {
                map.put(sum, i);
            }
        }
        }
        int[] ans = new int[ maxi];
        if (ans.length == 0) {list.add(-1);}
        for(int i=0; i< maxi ; i++)
        list.add (arr[st+i]);
        

        return list;
    }
}