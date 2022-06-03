/*Problem Description
Given a string S which consists of both lowercase and uppercase alphabetical letters, you have to write a function to check if string S is a permutation of a palindrome or not. Note: Characters are case sensitive i.e. ‘a’ is not the same as ‘A’.*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class PermutationPalindrome {

    public static int isPermutationPalindrome(String s) {

        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)))
                list.remove((Character) s.charAt(i));
            else
                list.add(s.charAt(i));
        }

        if (s.length() % 2 == 0 && list.isEmpty() || (s.length() % 2 == 1 && list.size() == 1))
            return 1;
        else
            return 0;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t--;
            String s = new String();
            s = sc.next();

            int flag = isPermutationPalindrome(s);
            if (flag == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

}