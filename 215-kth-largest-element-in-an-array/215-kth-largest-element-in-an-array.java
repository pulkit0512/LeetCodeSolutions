class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Method 1: O(NLogN) Using normal sorting
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        
        // Method 2: O(NLogK) using heap of size k
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0;i<k;i++){
        //     pq.add(nums[i]);
        // }
        // for(int i=k;i<nums.length;i++){
        //     if(pq.peek()<nums[i]){
        //         pq.poll();
        //         pq.add(nums[i]);
        //     }
        // }
        // return pq.peek();
        
        
        // Method 3: O(N) on average using QuickSelect
        // using QuickSelect to find Kth largest element i.e. (N-K)th index element
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    private int quickSelect(int nums[], int left, int right, int kSmall) {
        if(left==right){
            return nums[left];
        }
        Random rand = new Random();
        int pivot = left + rand.nextInt(right-left);
        pivot = partition(nums, left, right, pivot);
        if(pivot==kSmall){
            return nums[pivot];
        }else if(pivot>kSmall){
            return quickSelect(nums, left, pivot-1, kSmall);
        }else{
            return quickSelect(nums, pivot+1, right, kSmall);
        }
    }
    
    private int partition(int nums[], int left, int right, int pivot) {
        int idx = left;
        int val = nums[pivot];
        swap(nums, pivot, right);
        for(int i=left;i<=right; i++){
            if(nums[i]<val){
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, right, idx);
        return idx;
    }
    
    private void swap(int nums[], int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}