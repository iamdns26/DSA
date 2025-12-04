class Solution {
     public void helper(int[] nums , int idx,List<List<Integer>> ans ){
       int n = nums.length;
       if(idx == n){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i< n;i++){
            l.add(nums[i]);
        }
        ans.add(l);
        return;
       }
        HashSet<Integer> set = new HashSet<>();  // prevent duplicate pick
        for(int i = idx; i<n;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
           swap(i,idx,nums);
           helper(nums,idx+1,ans);
           swap(i,idx,nums);
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
}