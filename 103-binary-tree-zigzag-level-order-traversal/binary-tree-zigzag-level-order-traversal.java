
class Solution {
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public void oddPrint(TreeNode root,int level,int n ,List arr){
        if(root==null) return;
        if(level>n) return;
        if(level==n) arr.add(root.val);
        oddPrint(root.right,level+1,n,arr);
        oddPrint(root.left,level+1,n,arr);
    }
    public void evenPrint(TreeNode root,int level,int n,List arr){
        if(root==null) return;
        if(level>n) return;
        if(level==n) arr.add(root.val);
        evenPrint(root.left,level+1,n,arr); 
        evenPrint(root.right,level+1,n,arr);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int lvl = level(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0 ; i<lvl ; i++){
            List<Integer> arr = new ArrayList<>();
            if(i%2==0) evenPrint(root,0,i,arr);
            else oddPrint(root,0,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}