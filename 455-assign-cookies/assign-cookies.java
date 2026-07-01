class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;

        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }
            //else if(g[i]  s[j])
            else j++;

        }
        return count;
    }
}