class NumArray {

    int[] pre;
    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.pre = nums;
    }
    
    public int sumRange(int left, int right) {
        int ans = pre[right];
        if(left>0){
            ans -= pre[left-1];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */