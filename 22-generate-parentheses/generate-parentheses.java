class Solution {
    public void helper(String otp, List<String> ans, int left, int right, int n){
        if(otp.length() == 2*n){
            ans.add(otp);
            return;
        }
        if(left < n) helper( otp + '(' , ans , left+1, right , n);
        if(right < left) helper( otp + ')' , ans , left, right+1 , n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("" , ans , 0 , 0 , n);
        return ans;
    }
}