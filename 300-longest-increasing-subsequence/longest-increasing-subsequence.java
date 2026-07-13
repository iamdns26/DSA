class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){
            int idx = l.size()-1;
            if(nums[i] > l.get(idx)){
                l.add(nums[i]);
            }
            else{
                int lo = 0 , hi = l.size()-1;
                 while(lo < hi){
                    int mid = lo + (hi - lo) / 2;
                    if(l.get(mid) < nums[i]) lo = mid + 1;
                    else hi = mid;
                }
                l.set(lo,nums[i]);

            }
        }
        return l.size();
    }
}