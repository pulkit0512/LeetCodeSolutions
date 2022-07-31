class NumArray {

    int[] tree;
    int n;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.tree = new int[4*n + 1];
        this.n = n;
        buildTree(tree, nums, 0, n-1, 0);
    }
    
    private void buildTree(int[] tree, int[] nums, int st, int ed, int idx) {
        if(st==ed){
            tree[idx] = nums[st];
            return;
        }
        int mid = (st+ed)/2;
        buildTree(tree, nums, st, mid, 2*idx+1);
        buildTree(tree, nums, mid+1, ed, 2*idx+2);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        return;
    }
    
    public void update(int index, int val) {
        updateNode(tree, 0, n-1, index, val, 0);
    }
    
    private void updateNode(int[] tree, int st, int ed, int i, int val, int idx) {
        if(i<st || i>ed){
            return;
        }
        if(st==ed){
            tree[idx] = val;
            return;
        }
        int mid = (st+ed)/2;
        updateNode(tree, st, mid, i, val, 2*idx+1);
        updateNode(tree, mid+1, ed, i, val, 2*idx+2);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        return;
    }
    
    public int sumRange(int left, int right) {
        return query(tree, left, right, 0, n-1, 0);
    }
    
    private int query(int[] tree, int qs, int qe, int st, int ed, int idx) {
        if(qs>ed || qe<st){
            return 0;
        }
        if(qs<=st && qe>=ed){
            return tree[idx];
        }
        int mid = (st+ed)/2;
        int left = query(tree, qs, qe, st, mid, 2*idx+1);
        int right = query(tree, qs, qe, mid+1, ed, 2*idx+2);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */