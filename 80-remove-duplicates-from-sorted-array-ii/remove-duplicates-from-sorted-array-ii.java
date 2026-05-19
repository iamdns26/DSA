class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }
            else map.put(ele,1);
        }
        int i = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq==1) nums[i++] = key;
            else {
                nums[i++] = key;
                nums[i++] = key;
            }
        }
        return i;
    }
}