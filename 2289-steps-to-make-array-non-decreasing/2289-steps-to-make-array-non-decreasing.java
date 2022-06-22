class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int n = nums.length;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty() || nums[i]<=st.peek()[0]){
                st.push(new int[]{nums[i], 0});
            }else{
                int cnt = 0;
                while(!st.isEmpty() && nums[i]>st.peek()[0]){
                    cnt = Math.max(cnt+1, st.pop()[1]);
                }
                ans = Math.max(ans, cnt);
                st.push(new int[]{nums[i], cnt});
            }
        }
        return ans;
    }
}