/**

*/

import java.util.*;
import crio.ds.Tree.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;


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
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        diameterOfBinaryTree(root , diameter);

        return diameter.get() - 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root , AtomicInteger diameter){
        if(root == null)
            return 0;  

        int left = diameterOfBinaryTree(root.left , diameter);
        int right = diameterOfBinaryTree(root.right , diameter); 

        int maxDiameter = left + right + 1;
        diameter.set(Math.max(diameter.get() , maxDiameter));    
        
        return Math.max(left , right) + 1;
    }

}