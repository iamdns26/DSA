class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));  // sort by ending value

        int prev = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0 ; i < pairs.length ; i++){
            int curr = pairs[i][0] , last = pairs[i][1];
            if(curr > prev){
                count++;
                prev = last;
            }
        }
        return count;
    }
}