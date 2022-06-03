/**
Problem Description
Given a pointer to a node in a sorted circular singly linked list( sorted in ascending order), write a function to insert a value K into the list such that the linked list still remains a sorted circular list.


Note1: If the given pointer is null i.e. empty list, create a circular list with a new node and return the reference to the new node. Otherwise,return the initial input pointer given.


Note2: The list could have duplicate values. You can insert the new value in any place which will keep the list sorted.
*/

import java.util.*;
import crio.ds.List.ListNode;


public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}


class Solution{
	// Implement your solution here
	public ListNode insertIntoSortedCircularList(ListNode head,int insertVal)
	{
      ListNode newNode = new ListNode(insertVal);

      if(head == null){//if linkedlist is empty
         head = newNode;
         newNode.next = head;
         return head;
      }     

      else if(head.next == head){ // if there is only one node
         if(head.val >= insertVal){
            newNode.next = head;
            head.next = newNode;             
         }
         else{
            head.next = newNode;
            newNode.next = head;
         }
         return head;
      }
      else{
         ListNode curr = head;
		   ListNode start = null;
		   ListNode last = null;

         while(curr.val <= curr.next.val){
            curr = curr.next;
         }
         last = curr;
         curr = curr.next;
         start = curr;
         ListNode prev = newNode;

         while(curr.val < insertVal && curr.next != start){
            prev = curr;
            curr = curr.next;
         }
         if(curr.next == start)
         {
            if(curr.val < insertVal){
               prev = curr;
               curr = curr.next;
            }
         }
         if(prev != newNode){
            prev.next = newNode;
            newNode.next = curr;
         }
         else{
            last.next = newNode;
            newNode.next = start;
         }
      }
      return head;
	}   
}