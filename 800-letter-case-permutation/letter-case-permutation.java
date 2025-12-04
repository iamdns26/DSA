class Solution {
    public void helper(String inp, String otp, List<String> ans){
        if(inp.length()==0){
            ans.add(otp);
            return;
        }
        char ch = inp.charAt(0);
        int ascii = (int)ch;

        if(ch >= 48 && ch <= 57){
            String newInp = inp.substring(1);
            String newOut = otp + ch ;

            helper(newInp, newOut, ans);
        }
        else{
            String newInp = inp.substring(1);
            String newOut1 = otp + Character.toLowerCase(ch);
            String newOut2 = otp + Character.toUpperCase(ch); 

            helper(newInp, newOut1, ans);
            helper(newInp, newOut2, ans);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        String otp = "";
        helper(s,otp,ans);
        return ans;
    }
}