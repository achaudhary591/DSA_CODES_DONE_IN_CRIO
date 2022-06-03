/**
Problem Description
A string S is given consisting of lowercase alphabetical characters only. You need to return a sorted string using Count Sort.
*/


import java.util.*;

class CountSortOnString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String res = countSort(n, s);

        System.out.println(res);

    }

    static String countSort(int n, String s) {

        char[] newStr = s.toCharArray();

        char[] result = new char[n];
        int[] count = new int[256];

        for(int i = 0;i < 256; ++i)
            count[i] = 0;
        
        for(int i = 0; i < n; ++i)
            ++count[newStr[i]];

        for(int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        for(int i = 0; i < n; ++i){
            result[count[newStr[i]] - 1] = newStr[i];
            --count[newStr[i]];
        }

        for(int i = 0; i < n; ++i)
            newStr[i] = result[i];
        
        return String.valueOf(newStr);
        
    }
}