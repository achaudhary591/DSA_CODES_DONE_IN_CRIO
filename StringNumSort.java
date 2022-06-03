/**
Problem Description
Given an array, where integers are written as strings, sort the array and return it, with the elements still being strings.

Note that the number of digits in each element may go up to 10^6.
*/

import java.util.*;

class StringNumSort {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String sortedArray[] = numSort(n, arr);

        for (String num : sortedArray) {
            System.out.print(num + " ");
        }

    }

    static String[] numSort(int n, String[] arr) {

        Arrays.sort(arr , (left , right ) ->
        {
            if(left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });

        return arr;
    }
}