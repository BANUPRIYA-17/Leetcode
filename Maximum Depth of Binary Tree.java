
  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;


class Solution {
    public int maxDepth(TreeNode root) {
        // Base Case: If the tree is empty, depth is 0
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
