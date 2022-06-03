/**
Problem Description
Given 2 sorted linked lists, merge them into a new sorted linked list and return head of the merged list. The new list should be made by splicing (adjusting the pointers) together the nodes of the first two lists.
*/

import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;

public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next , l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1 , l2.next);
            return l2;
        }
    }
}