class Solution {
    public void wiggleSort(int[] nums) {
        //wiggleSortUsingQuickSelect(nums);
        //wiggleSortUsingPriorityQueue(nums);
        wiggleSortUsingCountSort(nums);
    }
    
    private void wiggleSortUsingCountSort(int nums[]) {
        int cnt[] = new int[5001];
        int next[] = new int[5001];
        for(int num:nums){
            cnt[num]++;
        }
        int last = 0;
        for(int i=5000;i>=0;i--){
            if(cnt[i]>0){
                next[i] = last;
                last = i;
            }
        }
        int n = nums.length;
        // Start populating even indices first from the right.
        // Since we are moving from small to large in next and count array.
        // And even indices will have smaller values.
        for(int i=1-n%2;i<n;i+=2){
            if(cnt[last]==0){
                last = next[last];
            }
            nums[n-1-i] = last;
            cnt[last]--;
        }
        for(int i=n%2;i<n;i+=2){
            if(cnt[last]==0){
                last = next[last];
            }
            nums[n-1-i] = last;
            cnt[last]--;
        }
    }
    
    private void wiggleSortUsingPriorityQueue(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            pq.add(x);
        }
        for(int i=1;i<nums.length;i+=2){
            nums[i] = pq.poll();
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i] = pq.poll();
        }
    }
    
    private void wiggleSortUsingQuickSelect(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return;
        }
        // Find the position of mid value in the array using quick select
        // all values to the left will be smaller then mid value and all values to the right will be greater then mid
        int mid = findKthLargest(nums, n/2);
        int val = nums[mid];
        int left = 1; // starts from odd index from the left
        int right = (n-1)%2==0?n-1:n-2; // starts from even index from the right
        int idx = 0;
        
        //The goal is to put all the greater than median numbers on the odd indices from the left
        //and put all the less than median numbers on the even indices from the right
        //and then the ones equals to the median to the remaining slots
        while(idx<n){
            if(nums[idx]>val && (idx%2==0 || idx>=left)){
                swap(nums, idx, left);
                left+=2;
            }else if(nums[idx]<val && (idx%2==1 || idx<=right)){
                swap(nums, idx, right);
                right-=2;
            }else{
                idx++;
            }
        }
    }
    
    private int findKthLargest(int nums[], int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    
    private int quickSelect(int nums[], int left, int right, int kSmall) {
        if(left==right){
            return left;
        }
        Random rand = new Random();
        int pivot = left + rand.nextInt(right-left);
        pivot = partition(nums, left, right, pivot);
        if(pivot==kSmall){
            return pivot;
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
    
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}