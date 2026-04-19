class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxLen = 0;

        while(j < s.length()){

            char ch = s.charAt(j);

            if(set.contains(ch)){

                int len = j - i;
                maxLen = Math.max(maxLen, len);

                while(s.charAt(i) != ch){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i)); // remove duplicate
                i++;
            }

            set.add(ch); 
            j++;
        }

        int len = j - i;
        maxLen = Math.max(maxLen, len);

        return maxLen;
    }
}