class Solution {
    public void helper(List<Integer> ans,int rowIndex) {
        if(rowIndex==0){
            ans.add(1);
            return;
        }
        List<Integer> l = new ArrayList<>();
        helper(l,rowIndex-1);
        ans.add(1);
        for(int i = 1 ; i < rowIndex ; i++){
            ans.add(l.get(i-1) + l.get(i));
        }
        ans.add(1);
        
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        helper(ans,rowIndex);
        return ans;
    }
}