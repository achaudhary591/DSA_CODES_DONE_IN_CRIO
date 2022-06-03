/**
Problem Description
You are given a X positive integer. You need to find the N-th root of X.

If the N-th root is in decimal you need to print its floor value e.g, floor(3.23) = 3.
*/

import java.util.*;

class NthRootUsingBS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int x = sc.nextInt();
            int n = sc.nextInt();

            int ans = nthRoot((double)x, n);

            System.out.println(ans);
        }
    }

    static int nthRoot(double x, int n){

        double low, high;
        if (x >= 0 && x <= 1)
        {
            low = x;
            high = 1;
        }
        else
        {
            low = 1;
            high = x;
        }
        double epsilon = 0.00000001;

        double guess = low + (high - low) / 2;
        while ((high - low) >= epsilon)
        {
            if (Math.pow(guess, n) > x)
            {
                high = guess;
            }
            else
            {
                low = guess;
            }
            guess = (low + high) / 2;
        }
        //System.out.println("guess = "+guess);
        //double result = (int)guess + epsilon;
        return (int)(guess + epsilon);
    }
        
}
