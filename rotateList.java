/**
Problem Description
Given the head to singly Linked List and a number K, rotate the list right by K nodes. Assume K is non-negative.
*/

/*
public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}
*/
import java.util.*;
import crio.ds.List.ListNode;

class Solution{

	public ListNode rotateList(ListNode head,int k)
	{
      
      if(head==null || head.next==null)return head;
    
      ListNode tmp = head;
      int cnt = 0;
         
      while(tmp != null){
         tmp=tmp.next;
         cnt++;
      }
        
      tmp=head;
      k %= cnt;
         
      if(k==0)
         return head;
         
      while(k-- > 0)
            tmp = tmp.next;
         
      ListNode tmpHead = head;
         
      while(tmp.next != null){
            tmp = tmp.next;
            head = head.next;
      }
         
      ListNode newHead = head.next;
      tmp.next = tmpHead;
      head.next = null;
         
      return newHead;
	}
}