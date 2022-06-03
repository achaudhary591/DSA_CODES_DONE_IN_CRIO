/**
Problem Description
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list i.e. the head of the copied linked list.

The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

The original list should be restored if modified.
*/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import crio.ds.List.*;


class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};


public class Solution{
    public Node copyRandomList(Node head) {

        Node cur = head , cloneCur = null;
        Map<Node , Node> map = new HashMap<Node , Node>();

        while(cur != null){
            cloneCur = new Node(cur.val , cur.next , cur.random);
            map.put(cur , cloneCur);
            cur = cur.next;
        }
        
        cur = head;

        while (cur != null)
        {
            cloneCur = map.get(cur);
            cloneCur.next = map.get(cur.next);
            cloneCur.random = map.get(cur.random);
            cur = cur.next;
        }        
        return map.get(head);
    }

}

/**
 * =========================================================================
 * ANOTHER APROACH O(1) SPACE AND O(N) TIME
 * public Node copyRandomList(Node head) {
        
         Node curr = head, temp = null;
 
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.val , curr.next , curr.random);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random; 
            curr = curr.next.next;                   
        }
 
        Node original = head, copy = head.next;
        temp = copy;
 
        while (original != null) {
            original.next =original.next.next;
 
          copy.next = (copy.next != null) ? copy.next.next
                                            : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

 * 
 * **/