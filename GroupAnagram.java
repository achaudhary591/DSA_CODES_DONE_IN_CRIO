/*
Problem Description
Given an array of strings, group anagrams together.

Input format
First line contains an integer N - Number of String.

Second line contains N strings.

Output format
Print each group on a separate line.

For each group print all anagrams of a group on a single line.

Note:The order of your output does not matter.

Sample Input 1
6

eat tea tan ate nat bat

Sample Output 1
ate eat tea

nat tan

bat
*/

import java.util.*;

class GroupAnagram {

    public List<List<String>> groupAnagram(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
 
        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);
    
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
        }
    }
 
    result.addAll(map.values());
 
    return result;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int check = 0;
        String strs[] = new String[n];
        for(int i = 0 ; i < n ;i++) {
            strs[i] = scanner.next();
        }
        List<List<String>> result = new GroupAnagram().groupAnagram(strs);

        for (int i = 0; i < result.size(); ++i) {
            for (int  j = 0; j < result.get(i).size(); ++j) {
                System.out.printf("%s ", result.get(i).get(j));
            }
            System.out.printf("\n");
        }
    }
}