class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0 , j = 0;
        while(j< arr.length){
            if(arr[i]==arr[j]) j++;
            else{
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}