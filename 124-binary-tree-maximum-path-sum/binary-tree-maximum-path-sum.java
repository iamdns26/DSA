class Solution {
    int mxSum = Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root==null) return 0;

        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        int currSum = root.val + left + right;

        mxSum = Math.max(mxSum,currSum);

        return root.val + Math.max(left,right);

        
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return mxSum;
    }
}