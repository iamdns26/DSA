class Solution {
    public int findMinArrowShots(int[][] arr) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr ,(a,b) -> Integer.compare(a[0],b[0]));

    
        int start = arr[0][0] , last = arr[0][1];
        int[] a = {start,last};

        ans.add(a);
        
        for(int i = 1 ; i < arr.length ; i++){
            
            int x1 = arr[i][0] , x2 = arr[i][1];
            if(x1 <= last){
                ans.remove(ans.size()-1);
                int[] b = {x1,Math.min(last,x2)};
                last = Math.min(last,x2);
                ans.add(b);
            }
            else{
                int[] c = {x1,x2};
                ans.add(c);
                last = x2;
            }
        }
        return ans.size();
    }
}