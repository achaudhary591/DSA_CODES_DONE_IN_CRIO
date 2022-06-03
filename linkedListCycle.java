/**
Problem Description
Given a linked list, determine if it has a cycle in it.


A linked list cycle means that for last node of LL, called last, last->next is not NULL, but instead points to some other node of the LL(not last itself)


Internally, to represent a cycle in the given linked list, we use an integer pos which represents the zero-indexed position of the node that the last node of the LL is connected to. If pos = -1, it means that there is no cycle in the LL. Note that pos is not passed as a parameter.


For instance, consider an LL 1->2->3->4 and pos = 1. This means that there is a cycle such that 4 is connected to the node at position 1, that is, the node with value 2.
*/

import crio.ds.List.*;

public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}

public class Solution {
    public boolean linkedListCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}