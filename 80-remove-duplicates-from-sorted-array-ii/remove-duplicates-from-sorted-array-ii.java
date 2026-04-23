class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int idx = 1;
        int count = 1;
        for(int i = 1 ;i < n ; i++){
            if(arr[i]==arr[i-1]) count++;
            else count = 1;

            if(count<=2) arr[idx++] = arr[i];
        }
        return idx;
    }
}