/* Problem Description
Given two strings s and t, write a function to determine if t is an anagram of s.

Note: You may assume the string contains only lowercase alphabets.

Input format
You will be given two strings in two separate lines. */

import java.io.*;
import java.util.*;

public class ValidAnagram {
    public boolean validAnagram(String s, String t) {

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int n1 = str1.length;
        int n2 = str2.length;

        if (n1 != n2)
            return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        boolean result = new ValidAnagram().validAnagram(s, t);
        System.out.print(String.valueOf(result));
    }
}