/**
Problem Description
You are given two strings and an integer k,find whether the given two strings are similar or not. Two given strings s1 and s2 are similar if for each character the difference between the frequency of that character in s1 and s2 is at most k. If the given strings are similar then print Yes otherwise print No. (Note : Both strings s1 and s2 are in lowercase )
*/

import java.util.*;

class SimilarStringUsingHashMap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String first_string = sc.next();
            String second_string = sc.next();
            String answer = similarString(n, m, first_string, second_string, k);
            System.out.println(answer);
        }
        sc.close();
    }

    static String similarString(int n, int m, String s, String t, int k) {

        Map<Character , Integer> str1Map = createFrquencyMap(s);
        Map<Character , Integer> str2Map = createFrquencyMap(t);
        
            for(Character c : str1Map.keySet()){
                if(str2Map.containsKey(c)){
                    if(Math.abs(str1Map.get(c) - str2Map.get(c)) > k){
                        return "No";
                    }                   
                }
                else{
                    if(str1Map.get(c) > k){
                        return "No";
                        
                    }                    
                }                
            }
            for(Character c : str2Map.keySet()){
                if(str1Map.containsKey(c)){
                    if(Math.abs(str1Map.get(c) - str2Map.get(c)) > k){
                        return "No";
                    }                    
                }
                else{
                    if(str2Map.get(c) > k){
                        return "No";
                        
                    }                   
                }                
            }            
        
        return "Yes";       
    }

    static Map<Character , Integer> createFrquencyMap(String a){        
       
        Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i<a.length();i++)
        {
            if(map.containsKey(a.charAt(i)))
            {
                int n= map.get(a.charAt(i))+1;
                map.put(a.charAt(i), n);
            }

            else
            {
                map.put(a.charAt(i), 1);
            }
        }
        return map;
    }   
}