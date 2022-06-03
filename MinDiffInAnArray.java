/**
Problem Description
Find the minimum difference possible between any two elements in the given array.
*/

import java.util.*;

class MinDiffInAnArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = minDiff(n, a);

        System.out.println(res);

    }

    static int minDiff(int n, int a[]) {

        Arrays.sort(a);

        int diff = Integer.MAX_VALUE;

        for (int i=0; i<n-1; i++)
              if (a[i+1] - a[i] < diff)
                  diff = a[i+1] - a[i];
          
           
        return diff;
    }
}