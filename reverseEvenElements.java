/**
Problem Description
Given a singly linked list of integers, reverse every contiguous set of nodes that have only even values.
*/

import java.util.*;
import crio.ds.List.ListNode;


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution{

	public ListNode reverseEvenElements(ListNode head)
	{
      if(head == null) 
         return null;

      ListNode curr = head;
      ListNode next = null;
      ListNode prev = null;

      while(curr != null && curr.val%2 == 0) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      if(curr != head) {
         head.next = curr;
         curr = reverseEvenElements(curr);
         return prev;
      } 
      else {
         head.next = reverseEvenElements(head.next);
         return head;
      }
   }	
}