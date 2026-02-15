class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            char num1 = '0';
            char num2 = '0';
            if(i>=0) num1 = a.charAt(i);
            if(j>=0) num2 = b.charAt(j);
            int num = (num1-48) + (num2-48) + carry;
            if(num==3){
                sb.append(1);
                carry = 1;
            }
            if(num==2){
                sb.append(0);
                carry = 1;
            }
            if(num==1){
                sb.append(1);
                carry = 0;
            }
            if(num==0){
                sb.append(0);
                carry = 0;
            }
            i-- ; j-- ;
        }
        if(carry==1) sb.append(1);
        sb.reverse();
        return sb.toString();
    }
}