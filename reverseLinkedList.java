/**
Problem Description
Given the elements of a linked list, reverse it.
*/

import java.util.*;
import crio.ds.List.ListNode;


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution{
	public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}