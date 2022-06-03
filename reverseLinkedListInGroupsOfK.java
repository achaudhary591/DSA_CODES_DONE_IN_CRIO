/**
Problem Description
Given a linked list, reverse the nodes of a linked list k at a time and return the modified list. If the number of nodes is not a multiple of K then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

import java.util.*;
import crio.ds.List.ListNode;


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution{
	public ListNode reverseLinkedListInGroupsOfK(ListNode head, int k){
      
      if(head==null||k==1)
        return head;
 
      ListNode fake = new ListNode(0);
      fake.next = head;
      ListNode prev = fake;
      int i=0;
 
      ListNode p = head;
    
      while(p!=null){
         i++;
         if(i%k==0){
               prev = reverse(prev, p.next);
               p = prev.next;
         }else{
               p = p.next; 
         }
      } 
      return fake.next; 
	}  

   public static ListNode reverse(ListNode prev, ListNode next){
      
      ListNode last = prev.next;
      ListNode curr = last.next;
 
      while(curr != next){
         last.next = curr.next;
         curr.next = prev.next;
         prev.next = curr;
         curr = last.next;
      } 
      return last; 
   }
}