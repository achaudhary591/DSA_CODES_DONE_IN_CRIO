/**
Problem Description
Given a string, find the length of the longest substring that contains at most K distinct characters.

Note:

Uppercase and Lowercase characters should be considered as different characters.

There can be numbers and special characters as well.
*/

import java.util.*;

// Implement your solution here
class LongestSubstringWithAtMostKDistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int result = 0;
    int i=0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
    for(int j=0; j<s.length(); j++){
        char c = s.charAt(j);
        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }else{
            map.put(c, 1);
        }
 
        if(map.size()<=k){
            result = Math.max(result, j-i+1);
        }else{
            while(map.size()>k){
                char l = s.charAt(i);
                int count = map.get(l);
                if(count==1){
                    map.remove(l);
                }else{
                    map.put(l, map.get(l)-1);
                }
                i++;
            }
        }
 
    }
 
    return result;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}