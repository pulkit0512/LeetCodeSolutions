class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        dq.addLast(n-1);
        for(int i=1;i<n;i++){
            //System.out.println(dq);
            nums[n-1-i] += nums[dq.peekFirst()];
            while(!dq.isEmpty() && dq.peekFirst()-(n-1-i)>=k){
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


/*
3
3 -4
7
7 4
7 5
-4 7
7 -5
-5 6
6 7
*/