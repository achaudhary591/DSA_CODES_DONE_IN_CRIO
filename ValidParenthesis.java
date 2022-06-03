import java.io.*;
import java.util.*;
//check balanced paranthesis 
public class ValidParenthesis {
    // Implement your solution here
    public String isValid(String s) {

        Deque<Character> stack = new ArrayDeque<Character>();
        
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty())
                return "false";
            char check;
            switch(c){

                case ')' :
                    check = stack.pop();
                    if(check == '{' || check == '[')
                        return "false";
                    break;
                 
                case '}' :
                    check = stack.pop();
                    if(check == '(' || check == '[')
                        return "false";
                    break;  
               
                case ']' :
                    check = stack.pop();
                    if(check == '{' || check == '(')
                        return "false";
                    break;
            }
        }
        if (stack.isEmpty())
            return "true";
        else
            return "false";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = in.readLine();
        String result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}