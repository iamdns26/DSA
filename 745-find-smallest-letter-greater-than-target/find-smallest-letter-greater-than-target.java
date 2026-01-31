class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int tar = (int)target;
        for(int i = 0 ; i < letters.length ; i++){
            char ch = letters[i];
            int num = (int)ch;
            if(num > tar) return ch;
        }
        return letters[0];
    }
}