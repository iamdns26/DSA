class Solution {
    public int helper(TreeNode root, long tar){
        if(root==null) return 0;
        int count = 0;
        if(root.val == tar) count++;
        count += helper(root.left,tar-root.val) + helper(root.right,tar-root.val);
        return count;

    }
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        int r = helper(root,target);
        int rl = pathSum(root.left,target);
        int rr = pathSum(root.right,target);

        return r + rl + rr;
    }
}