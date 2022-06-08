class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int st = 0, len = 0;
        for(int i=0;i<n;i++){
            if(min.isEmpty() || nums[min.peekLast()]<=nums[i]){
                min.addLast(i);
            }else{
                while(!min.isEmpty() && nums[min.peekLast()]>nums[i]){
                    min.pollLast();
                }
                min.addLast(i);
            }
            if(max.isEmpty() || nums[max.peekLast()]>=nums[i]){
                max.addLast(i);
            }else{
                while(!max.isEmpty() && nums[max.peekLast()]<nums[i]){
                    max.pollLast();
                }
                max.addLast(i);
            }
            if(nums[max.peek()]-nums[min.peek()]>limit){
                len = Math.max(len, i-st);
                if(max.peek()<min.peek()){
                    st = max.poll()+1;
                }else{
                    st = min.poll()+1;
                }
            }
        }
        len = Math.max(len, n-st);
        return len;
    }
}