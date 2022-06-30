class Solution {
    public int minMoves2(int[] nums) {
        //int mid = getMidElementNLogN(nums);
        //int mid = getMidElementNLogMid(nums);
        int mid = quickSelect(nums, 0, nums.length-1, nums.length/2);
        int moves = 0;
        for(int num:nums){
            moves += Math.abs(num-mid);
        }
        return moves;
    }
    
    private int quickSelect(int[] nums, int st, int ed, int kSmall) {
        if(st==ed){
            return nums[st];
        }
        Random rand = new Random();
        int pivot = st + rand.nextInt(ed-st);
        pivot = partition(nums, pivot, st, ed);
        if(pivot == kSmall){
            return nums[pivot];
        }else if(pivot>kSmall){
            return quickSelect(nums, st, pivot-1, kSmall);
        }else{
            return quickSelect(nums, pivot+1, ed, kSmall);
        }
    }
    
    private int partition(int[] nums, int pivot, int left, int right) {
        int idx = left;
        swap(nums, pivot, right);
        for(int i=left;i<right;i++){
            if(nums[i]<nums[right]){
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, right);
        return idx;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int getMidElementNLogN(int nums[]){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    private int getMidElementNLogMid(int nums[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int mid = (int)Math.ceil(n/2.0);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>mid){
                pq.poll();
            }
        }
        return pq.peek();
    }
}