class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < arr.length ; i++){
            if(Math.abs(arr[i] - arr[i-1]) < min){
                min = Math.abs(arr[i] - arr[i-1]);
            }
        }
        for(int i = 1 ; i < arr.length ; i++){
            int b = arr[i] - arr[i-1];
            if(Math.abs(b) == min){
                List<Integer> t = new ArrayList<>();
                t.add(arr[i-1]);
                t.add(arr[i]);
                ans.add(t);
            }
        }
        return ans;
    }
}