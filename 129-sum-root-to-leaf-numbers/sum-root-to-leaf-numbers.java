
class Solution {
    public void helper(TreeNode root, int s, int[] ans) {
        if(root==null) return;
        if(root.left == null && root.right==null){
            s = s * 10 + root.val;
            ans[0] += s;
        }
        s = s * 10 + root.val;
        helper(root.left,s,ans);
        helper(root.right,s,ans);
    }
    public int binaryTreePaths(TreeNode root) {
        int[] ans = {0};
        helper(root,0,ans);
        return ans[0];
    }
    public int sumNumbers(TreeNode root) {
        return binaryTreePaths(root);
    }
}