/**
Problem Description
Given only a reference to a node to be deleted in a singly linked list, implement a function to delete the given node. The given node is guaranteed to be neither the first, nor the last node.


Note: The node to be deleted is not necessarily the exact middle node but is one of nodes that is not at the ends.


Note: The input format will accept K, which denotes the position of the node to be deleted. However, in the function definition you’re given, you will not be given K. Instead, you’ll only have a pointer to the node to be deleted, and you have to use only that. You will not be able to use K. The challenge is to figure out how to delete this node without having a reference to the head of the linked list.
*/

import java.util.*;
import crio.ds.List.ListNode;



public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution {
    // Implement your Solution Here
    public static void deleteGivenNode(ListNode node) {

        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        System.gc();

    }
}