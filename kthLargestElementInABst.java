/**
Problem Description
Given a Binary Search Tree (BST) and a positive integer k, find the k’th largest element in the Binary Search Tree.

Input format
First line contains an integer n - Number of nodes.

Second line contains n space separated integers - The value of nodes.

Next n lines contain 3 space separated integers i, l, r describing left and right child of ith node as l and r respectively.
*/

import java.util.*;
import crio.ds.Tree.TreeNode;


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

    public long kthLargestElementInABst(TreeNode root, int k) {
       
        if(root == null)
            return Long.MIN_VALUE;
        
        Vector<Long> vec = new Vector<>();
        inOrder(root , vec);
        int n = vec.size();
        Collections.sort(vec);
        return vec.get(n - k);
        
    }
    static void inOrder(TreeNode root , Vector vec){
       
        if(root == null)
            return;
        
        inOrder(root.left , vec);
        vec.add(root.val);
        inOrder(root.right , vec);
    }

}