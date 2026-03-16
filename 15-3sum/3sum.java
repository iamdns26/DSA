class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            Set<Integer> hel = new HashSet<>();
            for(int j = i+1 ; j < n ; j++){
                List<Integer> temp = new ArrayList<>();
                int third = - (nums[i] + nums[j]);
                if(hel.contains(third)){
                    temp.add(nums[i]); temp.add(nums[j]); temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);

                }
                else hel.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}