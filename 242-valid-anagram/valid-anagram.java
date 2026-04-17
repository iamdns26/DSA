class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length() , m = t.length();
        if(n != m) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i < n ; i++){
            int ch1 = (int)s.charAt(i) - 'a';
            int ch2 = (int)t.charAt(i) - 'a';
            freq1[ch1]++;
            freq2[ch2]++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}