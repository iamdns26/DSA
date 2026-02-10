class Solution {
    public TreeNode convert(List<Integer> ans,int lo , int hi){
        if(lo>hi) return null;
        int mid = lo+(hi-lo)/2;
        int x = ans.get(mid);
        TreeNode root = new TreeNode(x);
        root.left = convert(ans,lo,mid-1);
        root.right = convert(ans,mid+1,hi);
        return root; 
    }
    public void inOrder(TreeNode root,List ans){
        if(root==null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return convert(ans,0,ans.size()-1);
    }
}