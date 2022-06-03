/**
Problem Description
You are given a linked list. You traverse through it in a unique fashion, based on the following rules :

Initially, you’re at the head.

Let k = head->value. You visit the kth node after head. That is, if the value of head-value = 1, you visit the node after the head. You repeat this process.

If there are less than K nodes after a particular node then you visit NULL.

You stop when you reach NULL.


You have to delete all the unvisited nodes in the linked list. Note that the head will never be deleted, as you always start at the head, and therefore, will always visit it.
*/

import java.util.*;
import crio.ds.List.ListNode;

/*
public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}
*/

public class Solution {
    void deleteUnvisitedNodes(ListNode head) {

        ListNode current = head;
        ListNode temp;
        
        while(current != null){
            int k = current.val;
            temp = NthNode(current,k);
            current.next = temp;
            current = current.next;
        }
    }
    
    static  ListNode NthNode(ListNode head, int k){
            
        int count = 0;
        ListNode current = head;
        
        while(current !=null){
            
            if(count == k)
                return current;

            ++count;
            current = current.next;
        }
        return null;
    }
}