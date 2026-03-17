class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i>0 && arr[i-1]==arr[i]) continue; // remove dublicacy

            int j = i+1 , k = n-1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0) k--;
                else if(sum < 0)  j++;
                else {
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]); l.add(arr[j]); l.add(arr[k]);
                    ans.add(l);
                    j++;
                    k--;
                    while(j<k && arr[k]==arr[k+1]) k--;
                    while(j<k && arr[j]==arr[j-1]) j++;
                }
            }
        }
        return ans;
    }
}