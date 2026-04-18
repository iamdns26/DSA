class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int s = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0 ; i < s ; i++){
                TreeNode node = q.remove();
                l.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(l);
        }
        return ans;
    }
}