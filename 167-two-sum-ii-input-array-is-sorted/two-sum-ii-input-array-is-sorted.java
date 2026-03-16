class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = {-1,-1};

        int i = 0 , j = arr.length-1;

        while(i<j){
            if(arr[i] + arr[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }

            if(target < arr[j] + arr[i]) j--;
            else if(target > arr[i] + arr[j]) i++;

        }
        return ans;
    }
}