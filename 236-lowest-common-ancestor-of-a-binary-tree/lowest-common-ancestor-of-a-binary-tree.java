
class Solution {
    public boolean exist(TreeNode root, TreeNode a){
        if(a==root) return true;
        if(root==null) return false;
        return exist(root.left,a) || exist(root.right,a);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;
        boolean a = exist(root.left,p);
        boolean b = exist(root.left,q);
        if(a && !b) return root;
        if(!a && b) return root;

        if(a) return lowestCommonAncestor(root.left,p,q);
        if(!a) return lowestCommonAncestor(root.right,p,q);

        return null;


    }
}