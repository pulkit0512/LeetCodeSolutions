class Solution {
    public long subArrayRanges(int[] nums) {
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