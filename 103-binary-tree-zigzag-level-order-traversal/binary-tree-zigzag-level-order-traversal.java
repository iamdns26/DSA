class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        q.add(root);
        boolean flag = true;

        while(q.size() > 0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode r = q.remove();
                list.add(r.val);
                if(r.left != null) q.add(r.left);
                if(r.right != null) q.add(r.right);
            }
            if(flag){
                ans.add(list);
                flag = false;
            }
            else {
                Collections.reverse(list);
                ans.add(list);
                flag = true;
            }
        }
        return ans;
    }
}