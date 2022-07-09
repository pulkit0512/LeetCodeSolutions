class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        dq.addLast(n-1);
        for(int i=1;i<n;i++){
            nums[n-1-i] += nums[dq.peekFirst()];
            if(!dq.isEmpty() && dq.peekFirst()-(n-1-i)==k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[n-1-i]){
                dq.pollLast();
            }
            dq.addLast(n-1-i);
        }
        return nums[0];
    }
}
