/**
Problem Description
You are given a string representing an arithmetic expression in Reverse Polish Notation(RPN), also known as Postfix notation.

You have to evaluate the value of the expression and return the anwer.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.

The given expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
*/


import java.util.*;


class ReversePolishNotation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Vector<String> vec = new Vector<String>();
        while(sc.hasNext())
        	vec.add(sc.next());
        System.out.println(reversePolishNotation(vec));
    }

    static int reversePolishNotation(Vector<String> vec){

        Stack<Integer> stack = new Stack<Integer>();
        String operators = "+-*/";        
        
        for(String i : vec){   
                     
            if(!operators.contains(i)){                
                stack.push(Integer.parseInt(i));
            }
            else{
                int x = stack.pop();
                int y = stack.pop();

                switch(i){
                    case "+" : stack.push(y + x); break;
                    case "-" : stack.push(y - x); break;
                    case "*" : stack.push(y * x); break;
                    case "/" : stack.push(y / x); break;                                
                }                
            }
        }        
        return stack.pop();
    }
}