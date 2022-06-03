/**
Problem Description
Given a singly linked list containing N integers, sort it in O(NlogN) time.
*/

import crio.ds.List.ListNode;

 public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
 


class Solution {

    public ListNode sortList(ListNode head) {
        
       if(head == null || head.next == null)
            return head;

        ListNode mid = getMidNode(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        ListNode sortedList = sortMerge(left , right);

        return sortedList;
    }

    public static ListNode getMidNode(ListNode head){

        if(head == null)
            return head;
        
        ListNode slowPtr = head , fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public static ListNode sortMerge(ListNode left , ListNode right){

        ListNode temp = new ListNode(0);
        ListNode prev = temp;

        while(left != null && right != null){
            if(left.val <= right.val){
                prev.next = left;
                left = left.next;
            }
            else{
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        if(left == null)
            prev.next = right;
        else
            prev.next = left;

        return temp.next;
    }
}