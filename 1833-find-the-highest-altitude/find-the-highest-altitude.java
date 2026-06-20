class Solution {
    public int largestAltitude(int[] gain) {
        int[] alttitude = new int[gain.length+1];
        int max = 0;
        for(int i = 0 ; i < gain.length ; i++){
            alttitude[i+1] = gain[i] + alttitude[i];
            if(alttitude[i+1] > max) max = alttitude[i+1];
        }
        return max;
    }
}