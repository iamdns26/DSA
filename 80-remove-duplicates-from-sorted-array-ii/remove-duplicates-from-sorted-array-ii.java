class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int i = 1;
        int j = 1;
        int count = 1;
        while(j<n){

            if(arr[j]==arr[j-1]) count++;
            else count = 1;

            if(count<=2) arr[i++] = arr[j];

            j++;
        }
        return i;
    }
}