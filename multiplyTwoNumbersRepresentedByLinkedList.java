/**
Problem Description
You are given two non-empty linked lists representing two non-negative integers.

Multiply the two numbers and return the answer.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

import java.util.*;
import crio.ds.List.ListNode;


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution{
	public Long multiplyTwoNumbersRepresentedByLinkedList(ListNode head1, ListNode head2)
	{
		long number1 = convertToNumber(head1);
      long number2 = convertToNumber(head2);      

      return number1*number2;
	}

   public static long convertToNumber(ListNode head){

      ListNode temp = head;
      int len = lengthOfList(temp);      
      long number = 0; 

      while(temp != null){
         number = number + (long)(Math.pow(10 , len) * temp.val);
         len--;
         temp = temp.next;
      }
      return number;
   }

   public static int lengthOfList(ListNode head){

      ListNode temp = head;
      int count = 0;
        
      while (temp != null){
         count++;
         temp = temp.next;
      }
      
      return (count - 1);
    } 
}