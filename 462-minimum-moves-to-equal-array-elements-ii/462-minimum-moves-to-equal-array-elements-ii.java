class Solution {
    public int minMoves2(int[] nums) {
        //int mid = getMidElementNLogN(nums);
        int mid = getMidElementNLogMid(nums);
        int moves = 0;
        for(int num:nums){
            moves += Math.abs(num-mid);
        }
        return moves;
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