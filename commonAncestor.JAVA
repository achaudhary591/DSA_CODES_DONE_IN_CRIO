/**

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
    TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {
        CounterNode n = helper(root, p, q);
        return n.node;
    }
 
    public CounterNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return new CounterNode(null, 0);
        }
 
        CounterNode left = helper(root.left, p, q);
        if(left.count==2){
            return left;
        }
 
        CounterNode right = helper(root.right, p, q);
        if(right.count==2){
            return right;
        }
 
        int c=left.count+right.count+(root==p?1:0)+(root==q?1:0);
 
        return new CounterNode(root, c);
 
    }
}
class CounterNode{
    public int count;
    public TreeNode node;
 
    public CounterNode(TreeNode node, int count){
        this.count=count;
        this.node=node;
    }
}





/*
ANOTHER APPROACH (RECURSIVE) ===========================================================
 TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {
        if(root==null)
            return null;
 
        if(root==p || root==q)
            return root;
    
        TreeNode l = commonAncestor(root.left, p, q);
        TreeNode r = commonAncestor(root.right, p, q);
    
        if(l!=null&&r!=null){
            return root;
        }else if(l==null&&r==null){
            return null;
        }else{
            return l==null?r:l;
        }
    }
*/