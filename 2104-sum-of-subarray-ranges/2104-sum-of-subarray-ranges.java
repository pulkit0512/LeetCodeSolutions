class Solution {
    public long subArrayRanges(int[] nums) {
        //return subArrayRangesN2(nums);
        return subArrayRangesN(nums);
    }
    
    private long subArrayRangesN(int[] nums) {
        int n = nums.length;
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        long maxSum = 0, minSum = 0;
        for(int i=0;i<=n;i++){
            maxSum += getMaxSum(maxStack, nums, i);
            minSum += getMinSum(minStack, nums, i);
        }
        return maxSum - minSum;
    }
    
    private long getMaxSum(Stack<Integer> maxStack, int[] nums, int idx) {
        long maxSum = 0;
        while(!maxStack.isEmpty() && (idx==nums.length || nums[maxStack.peek()]<nums[idx])){
            int pop_i = maxStack.pop();
            int prev_i = maxStack.isEmpty()?-1:maxStack.peek();
            maxSum += (idx-pop_i)*(pop_i-prev_i)*(long)nums[pop_i];
        }
        maxStack.push(idx);
        return maxSum;
    }
    
    private long getMinSum(Stack<Integer> minStack, int[] nums, int idx) {
        long minSum = 0;
        while(!minStack.isEmpty() && (idx==nums.length || nums[minStack.peek()]>nums[idx])){
            int pop_i = minStack.pop();
            int prev_i = minStack.isEmpty()?-1:minStack.peek();
            minSum += (idx-pop_i)*(pop_i-prev_i)*(long)nums[pop_i];
        }
        minStack.push(idx);
        return minSum;
    }
    
    private long subArrayRangesN2(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=2;i<=n;i++){
            ans += getSumOfSubarray(nums, i);
        }
        return ans;
    }
    
    private long getSumOfSubarray(int[] nums, int k) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        long sum = 0;
        for(int i=0;i<k;i++){
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]<=nums[i]){
                maxDeque.removeLast();
            }
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()]>=nums[i]){
                minDeque.removeLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
        }
        for(int i=k;i<nums.length;i++){
            sum += nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()];
            while(!maxDeque.isEmpty() && maxDeque.peekFirst()<=i-k){
                maxDeque.removeFirst();
            }
            while(!minDeque.isEmpty() && minDeque.peekFirst()<=i-k){
                minDeque.removeFirst();
            }
            
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]<=nums[i]){
                maxDeque.removeLast();
            }
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()]>=nums[i]){
                minDeque.removeLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
        }
        sum += nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()];
        return sum;
    }
}