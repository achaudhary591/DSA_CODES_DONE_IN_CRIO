/**
Problem Description
You are given a binary tree. You need to find the nodes in order of left to right which will be visible when the tree is viewed from the top.

Top view :-

image

The visible nodes from left to right are 4, 2, 1 and 3.
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

    public ArrayList<Long> topViewBinaryTree(TreeNode root) {
        ArrayList<Long> ans = new ArrayList<>();

        if (root == null) return ans;
         TreeMap<Long, Pair> map = new TreeMap<>();
         dfs(root, map, 0, 0);
         for (Pair p: map.values()){
             ans.add(p.nodeVal);
         }

        return ans;
    }
    
    static void dfs(TreeNode root, TreeMap<Long, Pair> map, long col, long depth) {
        if (root == null) return;
        if (!map.containsKey(col)){
            map.put(col, new Pair(depth, root.val));
        }else if (map.get(col).depth > depth){
                map.put(col, new Pair(depth, root.val));

        }
        dfs(root.left, map, col-1, depth+1);
        dfs(root.right, map, col+1, depth +1);
    }
}

class Pair{
    long nodeVal;
    long depth;
    public Pair(long depth, long nodeVal){
        this.nodeVal = nodeVal;
        this.depth = depth;
    }
}