class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n-1;
        int count = 0;
        while(i <= j){
           if(arr[i] + arr[j] <= limit){
            i++;
            j--;
           }
           else if(arr[i] < arr[j]) j--;
           else  i++;
           count++;
        }
        return count;
    }
}