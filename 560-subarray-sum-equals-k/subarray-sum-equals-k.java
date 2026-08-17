class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            arr[i]+=arr[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int rem = ele - k;
            if(ele==k) count++;
            if(map.containsKey(rem)){
                int freq = map.get(rem);
                count+=freq;
            }  
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(arr[i],freq+1);
            }  
            else map.put(ele,1);   
        }
        return count;
    }
}