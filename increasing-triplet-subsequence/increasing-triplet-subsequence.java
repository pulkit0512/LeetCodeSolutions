class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return false;
        }
        int ans[] = new int[3];
        ans[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>ans[len-1]){
                ans[len] = nums[i];
                len++;
            }else{
                //Since for this question this step can have length of atmost 2 so we can do it in O(1).
                int idx;
                if(len==1){
                    idx = 0;
                }else{
                    if(nums[i]<=ans[0]){
                        idx = 0;
                    }else{
                        idx = 1;
                    }
                }
                
                // This works faster for larger subsequences since it's in log n. LIS in NLogN in our case NLog2
                /*int idx = Arrays.binarySearch(ans, 0, len, nums[i]);
                if(idx<0){
                    idx = -(idx+1);
                }*/
                
                ans[idx] = nums[i];
            }
            if(len==3){
                return true;
            }
        }
        return false;
    }
}