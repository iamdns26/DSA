class NumArray {
    int[] seg;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(0,0,n-1,nums);
    }

    public void build(int i, int l , int r, int[] nums) {
        if(l==r){
            seg[i] = nums[l];
            return;
        }
        int mid = l + (r - l)/2;
        build(2*i+1, l, mid, nums);
        build(2*i+2, mid+1, r, nums);

        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public void updateHelper(int idx, int val, int i, int l , int r) {
        if(l==r){
            seg[i] = val;
            return;
        }
        int mid = l + (r - l)/2;
        if(idx <= mid) updateHelper(idx,val,2*i+1, l, mid);
        else updateHelper(idx,val,2*i+2, mid+1, r);

        seg[i] = seg[2*i+1] + seg[2*i+2];
    }

    public int sumRangeHelper(int st, int en, int i, int l, int r) {
        if(en < l || st > r) return 0;
        if(st <= l && r <= en) return seg[i];

        int mid = l + (r - l)/2;
        return sumRangeHelper(st, en, 2*i+1, l , mid) + sumRangeHelper(st, en, 2*i+2, mid+1 , r);
    }

    
    public void update(int index, int val) {
        updateHelper(index,val,0,0,n-1);
    }
    
    public int sumRange(int st, int en) {
        return sumRangeHelper(st, en, 0, 0 , n-1);
    }
}
