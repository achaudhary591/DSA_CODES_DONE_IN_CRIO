/**
Problem Description
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
*/

import java.util.*;


class NumberOfOneBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans = numberOfOneBits(n);
        System.out.print(ans);
    }

    static int numberOfOneBits(long n){

        int count  = 0;

        while(n != 0){

            count++;

            n = n & (n - 1);
        }

        return count;
    }
}