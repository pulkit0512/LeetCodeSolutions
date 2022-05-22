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
        while(i<this.list.size() && j<vec.list.size()){
            int key1 = this.list.get(i).getKey();
            int value1 = this.list.get(i).getValue();
            int key2 = vec.list.get(j).getKey();
            int value2 = vec.list.get(j).getValue();
            if(key1 == key2){
                ans += value1*value2;
                i++;
                j++;
            }else if(key1<key2){
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