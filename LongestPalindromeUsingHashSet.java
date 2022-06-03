/**
Problem Description
You are given a string consisting of lower and upper case characters.
You need to find the length of the longest palindrome which you can create by using the characters from the string.
Note: Upper case and lower case characters are different from each other i.e, "Aa" is not a palindrome as 'A' != 'a'.
*/

import java.util.*;

class LongestPalindromeUsingHashSet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int res = longestPalindrome(n, s);

        System.out.println(res);
    }

    static int longestPalindrome(int n, String s) {

        if(s==null || s.length()==0)
        return 0;

        HashSet<Character> hs = new HashSet<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty())
            return count * 2 + 1;

        return count * 2;
    }         
          
}