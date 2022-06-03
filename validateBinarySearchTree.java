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
    boolean validateBinarySearchTree(TreeNode root) {
        return validate(root, null, null);
	}

	private boolean validate(TreeNode root, Long low, Long high) {
		if (root == null) {
			return true;
		}

		if (low != null && root.val <= low 
				|| high != null && root.val >= high) {
			return false;
		}

		return validate(root.left, low, root.val) 
				&& validate(root.right, root.val, high);
	}
}