class Solution {
    public void helper(String inp, String otp, List<String> ans) {
        if (inp.length() == 0) {
            ans.add(otp);
            return;
        }

        char ch = inp.charAt(0);

        // If digit
        if (Character.isDigit(ch)) {
            helper(inp.substring(1), otp + ch, ans);
        } 
        else {
            // Lowercase branch
            helper(inp.substring(1), otp + Character.toLowerCase(ch), ans);

            // Uppercase branch
            helper(inp.substring(1), otp + Character.toUpperCase(ch), ans);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, "", ans);
        return ans;
    }
}
