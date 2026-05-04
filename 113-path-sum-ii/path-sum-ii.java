class Solution {
    public void helper(TreeNode root, int tar,List<Integer> l,int res, List<List<Integer>> ans){
        if(root==null) return;

        l.add(root.val);
        res += root.val;

        if (root.left == null && root.right == null) {
            if (res == tar) {
                ans.add(new ArrayList<>(l));
            }
        }
        
       
        helper(root.left,tar,l,res ,ans);
        helper(root.right,tar,l,res , ans);
        l.remove(l.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        //if(root==null || targetSum == 0) return ans;
        helper(root,targetSum,new ArrayList<>(),0,ans);
        return ans;
    }
}