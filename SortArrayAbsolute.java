/**
Problem Description
Given an array of integers, sort the array based on the absolute value of the elements.

Input format
First line contains an integer n - The number of elements.

Second line contains n space separated integers - The array nums.
*/

import java.util.*;

class SortArrayAbsolute {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        SortArrayAbsolute s = new SortArrayAbsolute(); 
        int res[] = s.sortArrayAbsolute(n, arr);

        for (int j : res)
            System.out.print(j + " ");
    }

     public class AbsComparator implements Comparator<Integer> {
        
        public int compare(Integer i1, Integer i2) {
           
            if(Math.abs(i1) < Math.abs(i2))
                return -1;
            else if(Math.abs(i1) > Math.abs(i2))
                return 1;
            else if(i1 < i2)
                return -1;
            else if(i1 > i2)
                return 1;
            else
                return 0;

        }
    }
    

    int[] sortArrayAbsolute(int n, int arr[]) {

        Integer[] copiedArray = new Integer[n];

        for(int i = 0; i < n; i++){
            copiedArray[i] = new Integer(arr[i]);
        }
    
        Arrays.sort(copiedArray, new AbsComparator());

        for(int i = 0;i < n; i++){
            arr[i] = copiedArray[i];
        }

        return arr;
    }
}