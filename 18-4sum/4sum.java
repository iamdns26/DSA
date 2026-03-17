class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(i > 0 && arr[i-1]==arr[i]) continue;
            for(int j = i+1 ; j < n ; j++){
                if(j > i+1 && arr[j-1]==arr[j]) continue;
                int p = j+1 , q = n-1;

                while(p < q){
                    long sum = (long)arr[i] + arr[j] + arr[p] + arr[q];
                    
                    if(sum > target) q--;
                    else if(sum < target) p++;
                    else{
                        List<Integer> a = new ArrayList<>();
                        a.add(arr[i]); a.add(arr[j]) ; a.add(arr[p]) ; a.add(arr[q]) ;
                        ans.add(a);
                        p++; q--;

                        while( p < q && arr[p-1] == arr[p]) p++;
                        while(p < q && arr[q+1] == arr[q]) q--;
                    }
                }
            }
        }
        return ans;
    }
}