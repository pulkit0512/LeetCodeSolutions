class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int idx = 0;
        
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        for(int i=k;i<nums.length;i++){
            ans[idx++] = nums[deque.peekFirst()];
            
            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        ans[idx++] = nums[deque.peekFirst()];
        
        return ans;
    }
}