import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        int maxCan = Integer.MIN_VALUE;

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq > maxFreq){
                maxFreq = freq;
                maxCan = key;
            }
         }
        return maxCan; 
    }
}
