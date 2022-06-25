class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int cnt1 = 0;
            for(int j=0;j<nums.length;j++){
                if(((nums[j]>>i)&1)==1){
                    cnt1++;
                }
            }
            if(cnt1%2==1 || cnt1>0){
                ans += (1<<i);
            }
        }
        return ans;
    }
}