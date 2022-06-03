/**
Problem Description
There are 2 LLs, and they intersect at a node N, after which they merge into 1 list.

Write a program to find the node at which the intersection of two singly linked lists begins.
*/

import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;
	
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
	public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null)
            return null;

        ListNode res = null;
        int n1 = getLength(head1);
        int n2 = getLength(head2);
        int diff = Math.abs(n1-n2);
        if (n1 > n2)
        {
            while (diff > 0)
            {
                --diff;
                head1 = head1.next;
            }
        }
        else if (n1 < n2)
        {
            while (diff > 0)
            {
                --diff;
                head2 = head2.next;
            }
        }
        while (head1 != null && head2 != null && head1 != head2)
        {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
	}

    static int getLength(ListNode head){
        ListNode temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}