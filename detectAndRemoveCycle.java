/**
Problem Description
Given only the head of a linked list, check whether the linked list contains cycle or not. If the linked list does not contain a cycle return false, otherwise remove the cycle and return true.
*/

import crio.ds.List.ListNode;

public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


public class Solution {
    public boolean detectAndRemoveCycle(ListNode head){

        if(head.next == null || head == null)
            return false;

        if(head.next == head){
            head.next = null;
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean isCycle = false;     
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycle = true;
                removeLoopPointer(slow , fast , head);
                break;
            }
        }       
        return isCycle; 
    }
    public static void removeLoopPointer(ListNode slow , ListNode fast , ListNode head){
        
            
            slow = head;

            if(slow != fast){
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next; 
                }
                fast.next = null;
            }
            else{
                while(fast.next != slow){
                    fast = fast.next;
                }
                fast.next = null;
            }
        
    }
}