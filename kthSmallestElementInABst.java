/**
Problem Description
Given a binary search tree, write a function to find the node with the kth smallest value in it and return its value.

Note: You may assume that k is always valid, 1 ≤ k ≤ BST's total elements.
*/

import crio.ds.Tree.TreeNode;
import java.util.*;


// Definition of TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}



public class Solution {

    public int kthSmallestElementInABst(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
 
        TreeNode p = root;
        int result = 0;
    
        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = (int)t.val;
                p = t.right;
            }
        }
 
        return result;
    }
}