class Solution {
    public void reverseAll(int i, int j, StringBuilder sb){
        while(i < j){
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(j);
            sb.setCharAt(i, ch2);
            sb.setCharAt(j, ch1);
            i++;
            j--;
        }
    }

    public String reverseStr(String s, int mx) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();

        if(n < mx){
            reverseAll(0, n - 1, sb);
            return sb.toString();
        }

        int i = 0;

        while(i < n){
            
            int j = Math.min(i + mx - 1, n - 1);
            reverseAll(i, j, sb);

            i = i + 2 * mx;
        }

        return sb.toString();
    }
}