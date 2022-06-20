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
                ans[idx] = nums[i];
            }
            //System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
            if(len==3){
                return true;
            }
        }
        return false;
    }
}