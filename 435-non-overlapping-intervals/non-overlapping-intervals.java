class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0],b[0]));
        
        int count = 0;
        int curr = arr[0][0] , last = arr[0][1] ;

        
        for(int i = 1 ; i < arr.length ; i++){
            int x1 = arr[i][0] , x2 = arr[i][1] ;
            if(x1 < last){
                count++;
                last = Math.min(x2,last);
            }
            else last = x2;
        }
        return count;
    }
}