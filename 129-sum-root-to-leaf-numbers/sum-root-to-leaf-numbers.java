
class Solution {
    public void helper(TreeNode root, int s, List<Integer> ans) {
        if(root==null) return;
        if(root.left == null && root.right==null){
            s = s * 10 + root.val;
            ans.add(s);
        }
        s = s * 10 + root.val;
        helper(root.left,s,ans);
        helper(root.right,s,ans);
    }
    public int binaryTreePaths(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,0,ans);
        int sum = 0;
        for(int i = 0 ; i < ans.size() ; i++){
            sum+=ans.get(i);
        }
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        return binaryTreePaths(root);
    }
}