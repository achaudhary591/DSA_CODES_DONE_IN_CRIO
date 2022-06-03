/**
Problem Description
Given a sorted array consisting of 0s and 1s only, find the index of the first 1. If there’s no 1 present in the array, return -1
*/

import java.util.*;

class ZeroOnesBinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = zeroOnes(n, a);
        System.out.println(res);

    }

    static int zeroOnes(int n, int a[]) {

        int low =0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(a[mid] == 1 && (mid == 0 || a[mid - 1] == 0))
                return mid;

            else if(a[mid] == 1)
                high = mid -1;
            else
                low = mid + 1;
            
        }

        return -1;
    }
}