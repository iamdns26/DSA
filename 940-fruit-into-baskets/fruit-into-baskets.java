class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0 , j = 0;
        int ans = 0;
        while(j<n){
            if(map.containsKey(arr[j])) map.put(arr[j],map.get(arr[j])+1);
            else map.put(arr[j],1);

            // if(map.size()<2){
            //     j++;
            // }
           if(map.size()<=2){
                int curr = 0;
                for(int key : map.keySet()){
                    curr+=map.get(key);
                }
                ans = Math.max(curr,ans);
                j++;
            }
            else if(map.size()>2){
                while(map.size() > 2){
                    map.put(arr[i],map.get(arr[i])-1);
                    if(map.get(arr[i])==0) map.remove(arr[i]);
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}