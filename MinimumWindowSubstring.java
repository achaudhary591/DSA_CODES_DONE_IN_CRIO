/**
Problem Description
Given a sorted integer array of length n with possible duplicate elements. Find the number of occurrences of an integer k using binary search.
*/

import java.io.*;
import java.util.*;

class MinimumWindowSubstring {

    public String minimumWindowSubstring(String a, String b) {

        char[] s = a.toCharArray();
        char[] t = b.toCharArray();
    
        int m[] = new int[256]; 
    
        int ans = Integer.MAX_VALUE; 
        int start = 0; 
        int count = 0;
        
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        } 
   
        int i = 0;
        int j = 0; 
        
        while (j < s.length)
        {      
            
            m[s[j]]--;
            if (m[s[j]] == 0)
                count--; 
            
            if (count == 0)
            {
                while (count == 0)
                {               
                    
                    if (ans > j - i + 1)
                    {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }               
                
                    m[s[i]]++;
                    if (m[s[i]] > 0)
                        count++;
    
                    i++;
                }
            }
            j++;
        }
 
        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start, ans+start);
        else
            return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        String result = new MinimumWindowSubstring().minimumWindowSubstring(a , b);
        System.out.println(result);
    }
}