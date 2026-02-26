
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;
        if(!isSameTree(p.left,q.left)) return false;
        if(!isSameTree(p.right,q.right)) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        root.right = invertTree(root.right);
        return isSameTree(root.left,root.right);
    }
}