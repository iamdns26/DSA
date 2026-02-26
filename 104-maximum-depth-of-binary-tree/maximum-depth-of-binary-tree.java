
class Solution {
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return 1 + Math.max(left,right);
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}