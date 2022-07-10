class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majority){
                cnt++;
            }else{
                cnt--;
                if(cnt==0){
                    majority = nums[i];
                    cnt = 1;
                }
            }
        }
        return majority;
    }
}