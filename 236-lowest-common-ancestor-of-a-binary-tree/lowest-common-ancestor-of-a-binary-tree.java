class Solution {
    public boolean exist(TreeNode root,TreeNode node){
        if(root==null) return false;
        if(node==root) return true;
        return exist(root.left,node) || exist(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p==root || q==root) return root;

        boolean pLeft = exist(root.left,p);
        boolean qLeft = exist(root.left,q);

        if(pLeft && !qLeft) return root;
        if(!pLeft && qLeft) return root;

        if(pLeft && qLeft) return lowestCommonAncestor(root.left,p,q);
        return lowestCommonAncestor(root.right,p,q);
    }
}