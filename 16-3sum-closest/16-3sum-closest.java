class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int j=i+1, k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(diff>Math.abs(target-sum)){
                    diff = Math.abs(target-sum);
                    ans = sum;
                }
                
                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else{
                    return sum;
                }
            }
        }
        
        return ans;
    }
}