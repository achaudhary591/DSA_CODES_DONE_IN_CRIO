/**
Problem Description
Reverse the bits of a given 32 bits unsigned integer.
*/

import java.util.*;


class ReverseBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-->0){
            long n = sc.nextLong();
            long ans = reverseBits(n);
            System.out.println(ans);
        }
    }

    static long reverseBits(long n){

        long reverse = 0;
        int count = 0;

        while (count < 32){

            reverse <<= 1;
            
            if((n & 1) == 1){
                reverse ^= 1;
            }

            n >>= 1;

            count++;
        }
        return reverse;
    }
}