
class Solution {
    public void storeLeaf(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        storeLeaf(root.left,list);
        storeLeaf(root.right,list);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        storeLeaf(root1,l1);
        storeLeaf(root2,l2);

        if(l1.size() != l2.size()) return false;
        System.out.println(l1);
        System.out.println(l2);

        for(int i = 0 ; i < l1.size() ; i++){
            if(!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }
}