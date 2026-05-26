class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int l = mat.length , m = mat[0].length;
        int top = 0 , left = 0 , right = m-1, down = l-1;
        int total = m*l;
        int n = 0;

        while(left <= right && top <= down){
            for(int j = left ; j <= right ; j++){
                ans.add(mat[top][j]);
                n++;
            }
            if(total==n) break;
            top++;
            for(int i = top ; i <= down ; i++){
                ans.add(mat[i][right]);
                n++;
            }
            if(total==n) break;
            right--;
            for(int j = right ; j >= left ; j--){
                ans.add(mat[down][j]);
                n++;
            }
            if(total==n) break;
            down--;
            for(int i = down ; i >= top ; i--){
                ans.add(mat[i][left]);
                n++;
            }
            if(total==n) break;
            left++;
        }
        return ans;
    }
}