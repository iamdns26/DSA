class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(n != m) return false;
        // concatenate the s to itself
        String conc = s + s ;
        // if(conc.contains(goal)) return true;
        // return false;
        return conc.contains(goal);

    }
}