class Solution {
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int removeElement(int[] arr, int val) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i<=j){
            if(arr[i]==val){
                swap(i,j,arr);
                j--;
            }
            if(arr[i] != val) i++;
        }
        return i;
    }
}