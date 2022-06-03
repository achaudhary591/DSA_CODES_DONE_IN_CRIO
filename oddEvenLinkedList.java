/**
Problem Description
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.
*/

import crio.ds.List.ListNode;

public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


public class Solution {
    public ListNode oddEvenLinkedList(ListNode head){
        
        if (head == null)
            return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;
    
        while (1 == 1)
        {
            if (odd == null || even == null || (even.next) == null)
            {
                odd.next = evenFirst;
                break;
            }

            odd.next = even.next;
            odd = even.next;

            if (odd.next == null)
            {
                even.next = null;
                odd.next = evenFirst;
                break;
            }
    
            even.next = odd.next;
            even = odd.next;
        }
        return head;
    }
}