class Solution {
    public int majorityElement(int[] nums) {
        int can = 0;
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(count == 0){
                can = nums[i];
            }
            if(can == nums[i]) count++;
            else count--;
        }
        return can;
    }
}