class Solution {
    public int maximumUnits(int[][] box, int size) {
        Arrays.sort(box, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int n = box.length;

        for(int i = n-1 ; i >= 0 ; i--){
            if(size==0) break;
            int noOfBox = box[i][0];
            int wetOfBox = box[i][1];
            
            if(noOfBox <= size){
                size -= noOfBox;
                ans += noOfBox * wetOfBox;
            }
            else if(size > 0){
                ans += size * wetOfBox;
                //break;
                size = 0;
            } 
            
        }
        return ans;
    }
}