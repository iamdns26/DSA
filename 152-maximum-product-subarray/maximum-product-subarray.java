class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int pro = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            pro *= arr[i];
            max = Math.max(max,pro);
            if(pro == 0) pro = 1;
        }

        int max1 = Integer.MIN_VALUE;
        int pro1 = 1;
        for(int i = n-1 ; i >= 0 ; i--){
            pro1 *= arr[i];
            max1 = Math.max(max1,pro1);
            if(pro1 == 0) pro1 = 1;
        }
        return Math.max(max,max1);
    }
}