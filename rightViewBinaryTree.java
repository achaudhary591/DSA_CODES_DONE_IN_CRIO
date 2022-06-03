/**
Problem Description
You are given a binary tree.

You need to find the nodes in order of top to bottom which will be visible when the tree is viewed from the right side.

Right view :-

image

The visible nodes from top to bottom are 1, 3 and 4.
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

    public ArrayList<Long> rightViewBinaryTree(TreeNode root) {

        ArrayList<Long> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }
    
    void helper(TreeNode root, ArrayList<Long> list, int depth) {
        
        if(root == null)
            return;
        
        if(list.size() == depth) {
            list.add(root.val);
        }
        
        helper(root.right, list, depth + 1);
        helper(root.left, list, depth + 1);
        
    }
}
/**
 * 
 * ANOTHER APPROACH DFS=================================
 * public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(que.size()>0)
        {
            TreeNode val = null;
            int qLen = que.size();
            for(int i = 0; i < qLen; i++)
            {
                TreeNode node = que.remove();
                if(node != null)
                {
                    val = node;
                    que.offer(node.left);
                    que.offer(node.right);
                }
            }
            if(val != null)
                res.add(val.val);
        }
        return res;
    }
*/