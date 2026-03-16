class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0 , j = n-1;

        int mxArea = 0;
        while(i<j){
            int width = j-i;
            int height = Math.min(arr[i],arr[j]);

            mxArea = Math.max(mxArea, width*height);

            if(arr[i] < arr[j]) i++;
            else j--;
        }
        return mxArea;
    }
}