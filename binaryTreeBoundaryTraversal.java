/**
Problem Description
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. The boundary includes left boundary, leaves, and right boundary in order.

The left boundary is defined as the path from the root to the left-most node. The right boundary is defined as the path from the root to the right-most node. If the root doesn’t have a left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined in the same way with left and right exchanged.
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

    public ArrayList<Long> binaryTreeBoundaryTraversal(TreeNode root) {
        ArrayList<Long> res = new ArrayList<>();

        if(root == null)
            return res;
        
        if(!isLeaf(root))
            res.add(root.val);

        TreeNode cur = root.left;

        while(cur != null){
            if (!isLeaf(cur)) 
                res.add(cur.val);
                
            if (cur.left != null) 
                cur = cur.left;

            else cur = cur.right;
        }

        addLeaves(root, res);

        cur = root.right;

        ArrayList<Long> temp = new ArrayList<>();

        while(cur != null){
            if (!isLeaf(cur)) 
                temp.add(cur.val);
            if (cur.right != null) 
                cur = cur.right;
            else cur = cur.left;
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
        return res;
    }

    boolean isLeaf(TreeNode root) {
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
    void addLeaves(TreeNode root, ArrayList<Long> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) 
            addLeaves(root.left, res);
        if (root.right != null) 
            addLeaves(root.right, res);
    }

}