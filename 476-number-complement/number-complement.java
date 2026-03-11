class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);

        StringBuilder sb = new StringBuilder();

        for(char ch : binary.toCharArray()){
            if(ch == '1') sb.append('0');
            else sb.append('1');
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
