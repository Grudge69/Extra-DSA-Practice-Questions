/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // base condition(at end of leaf node)
        if(root == null) return 0;
        
        // add 1 to the sub answer of whichever is having max depth among left and right sub tree
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}