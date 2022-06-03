/**
Problem Description
You are given to implement a stack which performs pushing, popping, and has a function findMin() which returns the minimum element present in the stack.

Push, pop and min should all operate in 0(1) time.


You will be given 3 types of queries. For each query you will be asked to perform suitable operations:

For query of type 1 x : push an element 'x' into the stack.

For query of type 2 : pop the last inserted element from the stack .

For query of type 3 : Find the minimum element from the stack. If the stack is empty, print -1.
*/

import java.util.*;

class MinStack {
  static Stack<Integer> stack = new Stack<Integer>();
  static Stack<Integer> min = new Stack<Integer>();

  static void push(Integer e) {
    if(stack.empty() == true){
      stack.push(e);
      min.push(e);
    }
    else{
      stack.push(e);
      int x = min.pop();
      min.push(x);
      
      if(e < x)
        min.push(e);
      else
        min.push(x);
    }
  }
  static void pop() {
    if(stack.empty() == false && min.empty() == false)
    {
      stack.pop();
      min.pop();
    }
  }
  static Integer findMin() {
    if(min.empty() == true){
      return -1;
    }     
    else{
      return min.peek();
    }

  }

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      Integer a = sc.nextInt();
      if (a == 1) {
        Integer e = sc.nextInt();
        push(e);
      }
      if (a == 2) {
        pop();
      }
      if (a == 3) {
        System.out.println(findMin());
      }
    }
  }
}