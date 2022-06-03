/**
Problem Description
Given 2 strings S and T containing lowercase and '#' characters. You have to check whether these 2 strings are same or not when typed into an editor('#' being the backspace character).


Note: Backspacing an empty string remains an empty string only. For eg. a#bc means bc, and a##bcd means bcd.
*/

import java.util.*;

class BackspaceStringCompare {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            String S = sc.next();
            String T = sc.next();

            boolean res = backspaceStringCompare(S, T);

            if (res)
                System.out.println(true);
            else
                System.out.println(false);

        }
    }

    static boolean backspaceStringCompare(String S, String T) {

        int ps = -1 , pt , i;
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();

        s.append(S);
        t.append(T);

        for(i = 0; i < s.length(); i++){

            if(s.charAt(i) == '#' && ps != -1)
                ps -= 1;
            
            else if(s.charAt(i) != '#'){
                s.setCharAt(ps + 1 , s.charAt(i));
                ps += 1;
            }
        }

        pt = -1;
        
        for(i = 0; i < t.length(); i++){
            
            if (t.charAt(i) == '#' && pt != -1)
                pt -= 1;
   
            else if (t.charAt(i) != '#')
            {
                t.setCharAt(pt + 1, t.charAt(i));             
                pt += 1;
            }
        }

        if (pt != ps)
            return false;
        
        else if (ps == -1 && pt == -1)
            return true;

        else
        {
            for(i = 0; i <= pt; i++)
            {
                if (s.charAt(i) != t.charAt(i))
                    return false;
            }
            return true;
        }
    }
}