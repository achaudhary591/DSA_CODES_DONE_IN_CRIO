/**
Problem Description
Given a linked list, remove the Kth node from the end of the list and return its head.
*/

import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;

Definition for ListNode
public class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
};

class Solution {
	public static ListNode deleteKthToLast(ListNode head, int k) {

        if(head == null){
            return null;
        }
        int count = 0;
        ListNode newNode = head;

        while(newNode != null){
            count = count + 1;
            newNode = newNode.next;
        }
        count = count - k;
        if(count == 0){
            return head.next;
        }
        ListNode curr = head;
        ListNode prev = null;

        while(count > 0){
            prev = curr;
            curr = curr.next;
            count = count - 1;
        }
        prev.next = curr.next;
        
        return head; 
	}
}





/**
=====================================================================================
ANOTHER APPROACH

	public static ListNode deleteKthToLast(ListNode head, int k) {
		if(head == null)
            return null;
        
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        for(int i = 1; i <= k; i++){
            firstPointer = firstPointer.next;
        }
        if(firstPointer == null)
            return head.next;
        
        while(firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        ListNode newNode = secondPointer.next;
        secondPointer.next = newNode.next;
        return head;
    } 

*/