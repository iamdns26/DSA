class Solution {
    public void helper(int[] arr, int idx, List<Integer> out, List<List<Integer>> ans){
        if(idx==arr.length){
            ans.add(new ArrayList<>(out));
            return;
        }
        List<Integer> list1 = new ArrayList<>(out);
        List<Integer> list2 = new ArrayList<>(out);
        list2.add(arr[idx]);

        helper(arr,idx+1,list1,ans);

        helper(arr,idx+1,list2,ans);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,0,list,ans);
        return ans;
    }
}