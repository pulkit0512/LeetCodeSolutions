class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Method 1: O(NLogN) Using normal sorting
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        
        // Method 2: O(NLogK) using heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
        
        
        // Method 3: O(N) on average using QuickSelect
        // using QuickSelect to find Kth largest element i.e. (N-K)th index element
        //return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    
    Random rand = new Random();
    private int quickSelect(int[] nums, int st, int ed, int kSmall) {
        if(st==ed){
            return nums[st];
        }
        
        int pivot = st + rand.nextInt(ed-st);
        pivot = partition(nums, st, ed, pivot);
        
        if(pivot==kSmall){
            return nums[pivot];
        }else if(pivot>kSmall){
            return quickSelect(nums, st, pivot-1, kSmall);
        }else{
            return quickSelect(nums, pivot+1, ed, kSmall);
        }
    }
    
    private int partition(int[] nums, int left, int right, int pivot) {
        int idx = left;
        swap(nums, pivot, right);
        for(int i=left;i<=right;i++){
            if(nums[i]<nums[right]){
                swap(nums, idx, i);
                idx++;
            }
        }
        swap(nums, idx, right);
        return idx;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}