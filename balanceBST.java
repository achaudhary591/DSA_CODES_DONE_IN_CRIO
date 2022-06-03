/**
Problem Description
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
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

    List<TreeNode> nodes;
    
    public TreeNode balanceBST(TreeNode root) {
        // fill in each level before proceed to next one
        // post order traversal to build the trees 
        nodes = new ArrayList();
        dfsGetList(root);
        return dfs(0, nodes.size()-1);
    }
    
    private void dfsGetList(TreeNode node) {
        if(node == null) return;
        dfsGetList(node.left);
        nodes.add(node);
        dfsGetList(node.right);
    }
    
    private TreeNode dfs(int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end - start)/2;
        TreeNode left = dfs(start, mid-1);
        TreeNode right = dfs(mid+1, end);
        TreeNode cur = nodes.get(mid);
        cur.left = left;
        cur.right = right;
        return cur;
    }

}