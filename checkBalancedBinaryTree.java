/**
Problem Description
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/

import java.util.*;
import crio.ds.Tree.TreeNode;

// Definition for TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }
}

public class Solution {
    boolean checkBalancedBinaryTree(TreeNode root) {

        if(root == null)
            return true;
        return (height(root) != -1);
    }

     public static int height(TreeNode root)
    {
        if(root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l , r) + 1;
    }
}