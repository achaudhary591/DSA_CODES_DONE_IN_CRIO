/**
Problem Description
Given a binary tree, return the root of the mirror binary tree. Mirror binary tree of a binary tree is a binary tree with left and right children of all nodes interchanged.
*/

import java.util.*;
import crio.ds.Tree.TreeNode;

/*
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

Use new TreeNode(data) to create new Node
*/
public class Solution {

    public TreeNode mirrorBinaryTree(TreeNode root) {

        if(root == null)
			return root;
		//invert left subtree
		if(root.left!=null)
			mirrorBinaryTree(root.left);
		//invert right subtree
		if(root.right!=null)
			mirrorBinaryTree(root.right);
		//swap left and right nodes
		TreeNode curr=root.left;
		root.left=root.right;
		root.right=curr;

        return root;
    }

}