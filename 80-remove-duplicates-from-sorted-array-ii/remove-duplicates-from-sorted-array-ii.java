class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int i = 1;
        int count = 1;
        for(int j = 1 ;j < n ; j++){
            if(arr[j]==arr[j-1]) count++;
            else count = 1;

            if(count<=2) arr[i++] = arr[j];
        }
        return i;
    }
}