class Solution {
    public double helper(double x,int n){
        if(n==1) return x;
        if(n==0) return 1;
        double half = helper(x,n/2);
        if(n%2==0){
            return half * half;
        }
        return half * half * x;
    }
    public double myPow(double x, int n) {
        if(n==1) return x;
        if(n==0) return 1;
        boolean flag = false;
        if(n<0){
            flag = true;
            n*=-1;
        }
        double ans = helper(x,n);
        if(flag) return 1/ans;
        return ans;
    }
}