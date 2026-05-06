class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(q.size() > 0){
            int size = q.size();
            int st = 0, en = 0;

            for(int i = 0 ; i < size ; i++){
                Pair p = q.remove();
                TreeNode node = p.node;
                int idx = p.idx;

                if(i==0) st = idx;
                if(i==size-1) en = idx;

                if(node.left != null) q.add(new Pair(node.left, 2 * idx));
                if(node.right != null) q.add(new Pair(node.right, 2 * idx +1 ));

            }
            max = Math.max(max,en-st+1);
        }
        return max;
    }
}