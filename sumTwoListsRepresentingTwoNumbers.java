/**
Problem Description
You’re given two numbers represented by two linked lists, where each node contains a single digit. The digits are stored in forward order i.e the one’s digit is at the tail of the list. Write a function that adds the two numbers and returns the sum as a linked list in the same order.
*/


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}
import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;
class Solution {
  public static ListNode sumLists1( ListNode head1 , ListNode head2) {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
 
    while (head1 != null)
    {
        stack1.add(head1.val);
        head1 = head1.next;
    }
 
    while (head2 != null)
    {
        stack2.add(head2.val);
        head2 = head2.next;
    }
 
    int carry = 0;
    ListNode result = null;
 
    while (!stack1.isEmpty() || !stack2.isEmpty())
    {
        int a = 0, b = 0;
 
        if (!stack1.isEmpty())
        {
            a = stack1.pop();
        }
 
        if (!stack2.isEmpty())
        {
            b = stack2.pop();
        }
 
        int total = a + b + carry;
 
        ListNode temp = new ListNode(total % 10);
        carry = total / 10;
 
        if (result == null)
        {
            result = temp;
        }
        else
        {
            temp.next = result;
            result = temp;
        }
    }
 
    if (carry != 0)
    {
        ListNode temp = new ListNode(carry);
        temp.next = result;
        result = temp;
    }
    return result;
  }
}