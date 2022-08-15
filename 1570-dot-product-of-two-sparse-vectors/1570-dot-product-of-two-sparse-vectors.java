class SparseVector {
    
    List<Pair<Integer, Integer>> list;
    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                list.add(new Pair(i, nums[i]));
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0;
        int ans = 0;
        while(i<this.list.size() && j<vec.list.size()) {
            int idx1 = this.list.get(i).getKey();
            int val1 = this.list.get(i).getValue();
            int idx2 = vec.list.get(j).getKey();
            int val2 = vec.list.get(j).getValue();
            
            if(idx1==idx2){
                ans = ans + val1*val2;
                i++;
                j++;
            }else if(idx1<idx2){
                i++;
            }else{
                j++;
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);