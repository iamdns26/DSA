class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';

        int len = (1 << n) - 1;
        int mid = (len / 2) + 1;

        if(mid == k) return '1';

        else if(k < mid) return findKthBit(n-1, k);
        
        else{

            int indx = len - k + 1;
            char curr = findKthBit(n-1, indx);
            return curr == '0' ? '1' : '0';
        }
    }
}