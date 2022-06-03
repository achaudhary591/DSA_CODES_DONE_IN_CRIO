/**
Problem Description
Given a singly linked list, find the middle node of the linked list and move that node to the head of the list. Return the head of the list. In the case of a list with an even number of nodes, use the second middle one.
*/




import java.util.*;
import crio.ds.List.ListNode;

public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}

class MakeHeadToMiddleNode{
	
	public ListNode moveMiddleToHead(ListNode head){

      ListNode s = head , f = head , p = null;

      while(f != null && f.next != null){
         p = s;
         s = s.next;
         f = f.next.next;
      }
      if(p != null){
         p.next = s.next;
         s.next = head;
         head = s;
      }
      return head;
   }
}