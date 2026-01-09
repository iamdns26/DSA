class Solution {
       public int depth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
        return 0;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth1 = depth(root.left), depth2 = depth(root.right);
        if (depth1 == depth2) {
            return root;
        }
        if (depth1 > depth2) {
            return subtreeWithAllDeepest(root.left);
        }
        return subtreeWithAllDeepest(root.right);
    }
}