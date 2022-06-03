/*
Problem Description
Partitioning an array means to split an array along an element, such that it divides the array into two parts with some specific property. The element that partitions the array is called the partitioning element.

Given an array, find the element, partitioning along which, the sum of elements to its left, equals the sum of elements to its right. The partition element itself is to be excluded from both sums.

Return the index of the partitioning element. If no such element exists, return -1.
*/

import java.util.*;

class EqualPartition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        int res = equalPartition(n, arr);

        System.out.println(res);

    }

    static int equalPartition(int n, long arr[]) {

        long[] prefix = new long[n];
        long leftsum = 0;

        for(int i = 0; i < n ; i++){
            prefix[i] = arr[i] + leftsum;
            leftsum = prefix[i];
        }

        
        for(int i = 0; i < n ; i++){
            long rightsum = prefix[n-1] - prefix[i];

            if(i != 0)
                leftsum = prefix[i-1];
            
            if(leftsum == rightsum)
                return i;
            
        }

        return -1;

    }
}
