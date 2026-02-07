class Solution {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int del = 0;
        int bCount = 0;
        for (char c : chars) {
            if (c == 'b') {
                bCount++;
            }
            else if (bCount > 0) {
                del++; 
                bCount--;
            }
        }
        return del;
    }
}