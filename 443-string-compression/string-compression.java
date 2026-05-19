class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) return 1;

        int left = 0;
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int right = 1; right < n; right++) {
            if (chars[left] != chars[right]) {
                if (count >= 1) {
                    res.append(chars[left]);
                    if (count > 1) res.append(count);
                }
                count = 1;
                left = right;
            }
            else count++;
        }
        if (count >= 1) {
            res.append(chars[left]);
            if (count > 1) res.append(count);
        }

        for (int i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }
        return res.length();
    }
}