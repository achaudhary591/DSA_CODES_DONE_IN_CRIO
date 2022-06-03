/**
Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes' values.

(i.e. from left to right, then right to left for the next level and alternate for every level).
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

public class BinaryTreeZigZagTraversalUsingQueue {

    public List<List<Long>>  zigzagLevelOrder(TreeNode root) {

        List<List<Long>> result = new ArrayList<List<Long>>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean fromLeft = true;

        while(!queue.isEmpty()){
            int numOfLevelNodes = queue.size();
            List<Long> currLevel = new LinkedList<Long>();

            for(int i = 0; i < numOfLevelNodes; i++){
                TreeNode currNode = queue.poll();

                if(fromLeft)
                    currLevel.add(currNode.val);
                else
                    currLevel.add(0 , currNode.val);
                
                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);                
            }
            result.add(currLevel);
            fromLeft = !fromLeft;
        }
        return result;
    }
}