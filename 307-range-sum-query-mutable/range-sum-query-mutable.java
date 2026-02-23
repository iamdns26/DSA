class NumArray {
    int[] segTree;
    int n;

    public void BuildTree(int i, int st, int en, int[] arr){
        if(st == en){
            segTree[i] = arr[st];
            return;
        }

        int mid = st + (en - st)/2;

        BuildTree(2*i+1, st, mid, arr);
        BuildTree(2*i+2, mid+1, en, arr);

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }

    public void UpdateQuery(int idx, int val, int i, int left, int right){
        if(left == right){
            segTree[i] = val;
            return;
        }

        int mid = left + (right - left)/2;

        if(idx <= mid) UpdateQuery(idx, val, 2*i+1, left, mid);
        else UpdateQuery(idx, val, 2*i+2, mid+1, right); 

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }

    public int QuerySum(int i, int st, int en, int left, int right){
        
        if(en < left || st > right) return 0;

        if(st >= left && en <= right) return segTree[i];

        int mid = st + (en - st)/2;

        return QuerySum(2*i+1, st, mid, left, right) + QuerySum(2*i+2, mid+1, en, left, right);
    }

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        BuildTree(0, 0, n-1, nums);
    }
    
    public void update(int index, int val) {
        UpdateQuery(index, val, 0, 0, n-1);
    }
    
    public int sumRange(int left, int right) {
        return QuerySum(0, 0, n-1, left, right);
    }
}