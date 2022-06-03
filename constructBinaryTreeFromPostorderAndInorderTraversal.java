/**
Problem Description
Given postorder and inorder traversal of a tree, construct the binary tree and return its root. Note: You may assume that duplicates do not exist in the tree.
*/

// Definition of TreeNode
import java.util.*;

class TreeNode {
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
    public TreeNode constructBinaryTreeFromPostorderAndInorderTraversal(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inorderValuetoIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inorderValuetoIndexMap.put(inorder[i], i);
        }
        
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, inorderValuetoIndexMap);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inorderValuetoIndexMap) {
        
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        TreeNode newNode = new TreeNode(rootVal);
        
        int inOrderIndex = inorderValuetoIndexMap.get(rootVal);
        int inOrderLeftLen = inOrderIndex - inStart;
        
        newNode.left = buildTree(inorder, postorder, inStart, inOrderIndex - 1, postStart, postStart + inOrderLeftLen - 1, inorderValuetoIndexMap);
        newNode.right = buildTree(inorder, postorder, inOrderIndex + 1, inEnd, postStart + inOrderLeftLen, postEnd - 1, inorderValuetoIndexMap);
        
        return newNode;
    }
}