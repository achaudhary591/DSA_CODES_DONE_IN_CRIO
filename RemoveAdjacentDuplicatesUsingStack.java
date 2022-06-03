/**
Problem Description
You are given a string s, consisting of lowercase letters. You need to make duplicate removal on s until you no longer can.


A duplicate removal consists of choosing two adjacent equal characters and removing both of them.
Return the final string after all such duplicate removals have been made.
*/

import java.util.*;


class RemoveAdjacentDuplicatesUsingStack{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        String result = removeAdjacentDuplicates(s);
        System.out.println(result);

        sc.close();
    }

    static String removeAdjacentDuplicates(String s){

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }
            else{
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder("");        
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());            
        }
        String x = String.valueOf(sb); 
        
        return reverse(x);
    }
    public static String reverse(String s){
        
        char[] ar = s.toCharArray();
        
        int left = 0;
        int right = ar.length-1;
        
        while(left<right){
            
            char c = ar[right];
            ar[right] = ar[left];
            ar[left] = c;
            
            left++;
            right--;    
        }     
        
        return new String(ar);          
    }
}