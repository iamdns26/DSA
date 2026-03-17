class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);

       int passMe = arr[0] + arr[1] + arr[2];

        for(int i = 0 ; i < n ; i++){
            if(i>0 && arr[i-1] == arr[i]) continue;
            int j = i+1 , k = n-1;

            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(Math.abs(target-sum) < Math.abs(target-passMe)) passMe = sum;
                else if(sum > target) k--;
                else if(sum < target) j++;
                else return sum; 
                
            }
        }
        return passMe;
    }
}