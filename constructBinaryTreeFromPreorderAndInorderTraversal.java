/**
Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

Note: You may assume that duplicates do not exist in the tree.
*/

// Definition of TreeNode
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

    public TreeNode constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder) {

        int h = inorder.length - 1;
        return solve(preorder , inorder , 0 , h , 0 , h);
    }

    public TreeNode solve(int[] preorder , int[] inorder , int prei , int prej, int ioi, int ioj){
        if(prei>prej){
            return null;
        }

        TreeNode root =new TreeNode(preorder[prei]);
        int ljt=0;
        
        for(int i=ioi; i<=ioj; i++){
           if(inorder[i]==preorder[prei]){
               ljt= i;
               break;
           }
        }

        int sj = ljt-ioi;
        root.left = solve(preorder,inorder,prei+1,prei+sj,ioi,ljt-1);
        root.right= solve(preorder,inorder,prei+sj+1,prej,ljt+1,ioj);
        return root; 
    }    
}