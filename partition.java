/**
Problem Description
Given a linked list and an integer X, partition the LL around X, such that all nodes less than X come before all nodes greater than X. If X is contained within the list, then those nodes need

to be after the elements less than X and before the elements greater than X, i.e. they should appear between the left and right partitions.


You can also see if you can preserve the order for elements on either side of the partition. For instance, for given LL 2, 6, 5, 7, 1 and X = 5, the answer should be 2, 1, 5, 6, 7 only, instead of 1, 2, 5, 6, 7.
*/

/*
public class ListNode {
   public int val; 
   public ListNode next;
   public ListNode(int x) { val = x; next = null; }
}
*/
import java.io.*;
import java.util.*;
import crio.ds.List.ListNode;
class Solution {
  public static ListNode partition( ListNode head , int x) {
    ListNode less = null;
    ListNode lessLast = null;
    ListNode equal = null;
    ListNode equalLast = null;
    ListNode greater = null;
    ListNode greaterLast = null;
    ListNode cur = head;
    ListNode nextNode;

    while(cur != null){
      nextNode = cur.next;

      if(cur.val < x){
        
        if(less == null){
          less = cur;
          lessLast = less;
          lessLast.next = null;
        }
        else{
          lessLast.next = cur;
          lessLast = lessLast.next;
          lessLast.next = null;
        }
      }
      else if(cur.val == x){
        
        if(equal == null){
          equal = cur;
          equalLast = equal;
          equalLast.next = null;
        }
        else{
          equalLast.next = cur;
          equalLast = equalLast.next;
          equalLast.next = null;
        }
      }
      else{

        if(greater == null){
          greater = cur;
          greaterLast = greater;
          greaterLast.next = null;
        }
        else{
          greaterLast.next = cur;
          greaterLast = greaterLast.next;
          greaterLast.next = null;
        }
      }
      cur = nextNode;
    }
    if(less == null){

      if(equal == null){
        return greater;
      }
      equalLast.next = greater;
      return equal;
    }

    if(equal == null){
      lessLast.next = greater;
      return less;
    }
    lessLast.next = equal;
    equalLast.next = greater;
    return less;
  }
}