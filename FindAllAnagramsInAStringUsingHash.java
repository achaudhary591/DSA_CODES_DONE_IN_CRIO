/**
Problem Description
You are given two strings, a main string S, and a pattern P. You have to find the starting indices of the anagrams of P in S.


Anagrams are permutations of a string. For P="abc”, its anagrams are abc,acb,bca,bac,cba,cab.
*/

import java.util.*;

// Implement your solution here
class FindAllAnagramsInAStringUsingHash {

     public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new ArrayList<Integer>();
       Map<Character , Integer> charFrequency = createMap(p);
       int windowStart = 0 , windowEnd = 0 , numCharMatched = 0;

       for(; windowEnd < s.length(); windowEnd++){
           char endChar = s.charAt(windowEnd);

            if(charFrequency.containsKey(endChar)){
                charFrequency.put(endChar , charFrequency.get(endChar) - 1);

                if(charFrequency.get(endChar) == 0)
                    numCharMatched++;
            }

            if(numCharMatched == charFrequency.size())
                result.add(windowStart);
            
            if(windowEnd >= p.length() - 1){
                char startChar = s.charAt(windowStart++);

                if(charFrequency.containsKey(startChar)){
                    if(charFrequency.get(startChar) == 0){
                        numCharMatched--;
                    }
                    charFrequency.put(startChar , charFrequency.get(startChar) + 1);
                }
            }
       }
       return result;
    }

    public Map<Character, Integer> createMap(String p)
    {
        Map<Character , Integer> map = new HashMap<>();
        for(char character : p.toCharArray()){
            map.put(character , map.getOrDefault(character , 0) + 1);
        }
        return map;
    }  
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String[] input = new String[2]; 
	    input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
	    System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }
}

/*BRUTE FORCE APPROACH------------------------

public List<Integer> findAnagrams(String s, String p) {

    int sn = s.length();
        int pn = p.length();
        List<Integer> res = new ArrayList<>();
        if (sn<=0 || pn<=0) return res;
        
        int[] pArr = new int[26];
        for (int i = 0; i < pn; i ++)
        {
            char c = p.charAt(i);
            pArr[(int)(c-'a')] ++;
        }
        
        for (int i = 0; i <= sn-pn; i ++)
        {
            char c = s.charAt(i);
            if (pArr[(int)(c-'a')]==0) continue;
            if (isAnagram(s, i, i+pn-1, pArr))
            {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isAnagram(String s, int start, int end, int[] pArr)
    {
        int[] sArr = new int[26];
        for (int i = start; i <= end; i ++)
        {
            char c = s.charAt(i);
            if (pArr[(int)(c-'a')]==0) return false;
            sArr[(int)(c-'a')] ++;
            if (pArr[(int)(c-'a')]<sArr[(int)(c-'a')]) return false;
        }
        
        return true;
    }
    ======================================================================================


ANOTHER APPROACH-------------------------
public List<Integer> findAnagrams(String s, String p) {

        int sn = s.length();
        int pn = p.length();
        List<Integer> res = new ArrayList<>();
        if (sn<=0 || pn<=0) return res;
        
        int[] pArr = new int[26];
        for (int i = 0; i < pn; i ++)
        {
            char c = p.charAt(i);
            pArr[(int)(c-'a')] ++;
        }
        
        int[] sArr = new int[26];
        for (int i = 0; i < sn; i ++)
        {
            char c = s.charAt(i);
            sArr[(int)(c-'a')] ++;
            if (i>=pn)
            {
                char c2 = s.charAt(i-pn);
                sArr[(int)(c2-'a')] --;
            }
            
            if (Arrays.equals(pArr,sArr))
            {
                res.add(i-pn+1);
            }
        }
        
        return res;
    }

*/    