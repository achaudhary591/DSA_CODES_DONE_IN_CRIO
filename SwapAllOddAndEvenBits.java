/**
Problem Description
Given an unsigned integer N, swap all odd bits with even bits. Every even position bit is swapped with the adjacent bit on the right side and every odd position bit is swapped with adjacent on the left side. Assume a 32 bit integer.
*/

import java.io.*;
import java.util.*;

class SwapAllOddAndEvenBits {

    // Complete the function below
    public long swapBits(long n) {

        long em = n & 0XAAAAAAAA;
        long om = n & 0X55555555;

        em >>= 1;
        om <<= 1;

        return em | om;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }
}