/**
Problem Description
Given a linked list(need not be sorted) with duplicates, remove all duplicates, such that only the first occurrence of each element must remain in the LL, and return the head.
*/


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}

import java.util.*;

import crio.ds.List.ListNode;

class Solution{
	public static void removeDuplicates(ListNode head)
	{
      HashSet<Integer> hs = new HashSet<>();
 
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            int curval = current.val;
 
            if (hs.contains(curval)) {
                prev.next = current.next;
            }
            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
	}
}