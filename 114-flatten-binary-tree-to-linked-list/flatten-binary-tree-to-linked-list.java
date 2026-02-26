class Solution {
    
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;

        TreeNode l = root.left;
        TreeNode r = root.right;

        flatten(root.left);
        flatten(root.right);

       root.right = l;
       root.left = null;

       TreeNode temp = root;
       while(temp.right != null) temp = temp.right;

       temp.left = null;
       temp.right = r;
    }
}