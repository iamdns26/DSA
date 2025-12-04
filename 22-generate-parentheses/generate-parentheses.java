class Solution {
    public boolean check(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') count++;
            else count--;
            if(count < 0) return false;
        }
       return count==0 ;
    }
    public void helper(String otp, List<String> ans, int level, int n){
        if(level == 2*n){
            if(check(otp)){
                ans.add(otp);
            }
            return;
        }
        helper( otp + '(' , ans , level+1 , n);
        helper( otp + ')' , ans , level+1 , n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("" , ans , 0 , n);
        return ans;
    }
}