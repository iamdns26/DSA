class Solution {
    public boolean checkString(String s) {
        int idx = -1;
        int i = 0;
        boolean flag = false;
        for(int j = 0 ; j < s.length() ; j++){
            if(s.charAt(j)=='a'){
                flag = true;
                break;
            }
        }
        if(!flag) return true;

        while(i<s.length() && s.charAt(i) != 'b') i++;
        idx = i;
        
        for(i=idx ; i < s.length() ; i++){
            if(s.charAt(i)=='a') return false;
        }

        return true;

    }
}