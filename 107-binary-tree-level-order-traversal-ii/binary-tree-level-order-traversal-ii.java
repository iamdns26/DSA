class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null ) return ans;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size() != 0){
            int size = qu.size();
            List<Integer> a = new ArrayList<>();
            for(int i = 1 ; i <= size ; i++){
                TreeNode r = qu.remove();
                a.add(r.val);
                if(r.left != null) qu.add(r.left);
                if(r.right != null) qu.add(r.right);
            }
            ans.add(0,a);
        }
        //Collections.reverse(ans);
        return ans;
    }
}