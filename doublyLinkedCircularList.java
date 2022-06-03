/**
Problem Description
Given a singly linked list, convert it into a doubly linked circular list(DCLL).

image

*/

import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;

// Definition for ListNode
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
	public static class DoublyLinkedListNode {
		int val;
		public DoublyLinkedListNode  prev;
		public DoublyLinkedListNode  next;
	
		DoublyLinkedListNode(int x, DoublyLinkedListNode p , DoublyLinkedListNode  n ) {
			val = x;
			prev = p;
			next = n;
		}
	}


	public static DoublyLinkedListNode doublyLinkedCircularList(ListNode head) {
        
        DoublyLinkedListNode Dlhead = null;
        DoublyLinkedListNode Dlprev = null;
        ListNode curr = head;
        
        if( head == null )
            return null;
        while( curr != null )
        {
            DoublyLinkedListNode temp = new DoublyLinkedListNode(curr.val , null , null);

            if( Dlhead == null)
            {
                Dlhead = temp;
                Dlprev = temp;
            }   
            else
            {
                Dlprev.next = temp;
                temp.prev = Dlprev;
                Dlprev = Dlprev.next;
            }
            curr = curr.next;
        }
        Dlprev.next = Dlhead;
        Dlhead.prev = Dlprev;
        return Dlhead;
	}
}