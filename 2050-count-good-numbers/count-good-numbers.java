class Solution {
    static final long MOD = 1000000007;

    private long power(long base, long exp) {
        if (exp == 0) return 1;

        long half = power(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) result = (result * base) % MOD;

        return result;
    }

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;   
        long odd  = n / 2;        

        long part1 = power(5, even); 
        long part2 = power(4, odd);  

        return (int)((part1 * part2) % MOD);
    }
}
