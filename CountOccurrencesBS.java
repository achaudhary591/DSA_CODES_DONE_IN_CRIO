/**
Problem Description
Given a sorted integer array of length n with possible duplicate elements. Find the number of occurrences of an integer k using binary search.
*/

import java.util.*;

class CountOccurrencesBS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int res = countOccurrences(n, k, a);

        System.out.println(res);
    }

    static int countOccurrences(int n, int k, int a[]) {

        int index = binarySearch(a , n , k);

        if(index == -1)
            return 0;

        int left = index - 1;
        int leftCount = 0;                    

        while(left > -1 && a[left] == k){
            leftCount++ ;
            left--;
        }

        int right = index + 1;
        int rightCount = 0;

        while(right < n && a[right] == k){
            rightCount++;
            right++;
        }

        return (leftCount + 1 + rightCount);
    }

    static int binarySearch(int[] arr , int size , int k){
        int low = 0;
        int high = size-1;
        int mid;
        
        while(low<=high){
            
            mid = low + (high-low)/2;
            if(arr[mid] == k)
                return mid;
            else
                if(arr[mid] < k)
                    low = mid + 1;
                else
                    high = mid - 1;
        }
        return -1;
    }

}