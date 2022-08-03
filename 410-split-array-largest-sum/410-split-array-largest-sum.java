class Solution {
    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = low;
        while(low<=high){
            int mid = (low+high)/2;
            int sum = nums[0], cnt = 1;
            for(int i=1;i<nums.length;i++){
                sum += nums[i];
                if(sum>mid){
                    sum = nums[i];
                    cnt++;
                    if(cnt>m){
                        break;
                    }
                }
            }
            if(cnt<=m){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}