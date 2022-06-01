class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //return minimumMountainRemovalsN2Time(nums);
        
        return minimumMountainRemovalsNLogNTime(nums);
    }
    
    private int minimumMountainRemovalsNLogNTime(int [] nums) {
        int[] lis = getLisNLogN(nums);
        reverse(nums);
        int[] lds = getLisNLogN(nums);
        
        return getMinimumRemovals(lis, lds);
    }
    
    private int minimumMountainRemovalsN2Time(int[] nums) {
        int[] lis = getLisN2(nums);
        reverse(nums);
        int[] lds = getLisN2(nums);
        
        return getMinimumRemovals(lis, lds);
    }
    
    private int[] getLisNLogN(int[] nums) {
        int[] lis = new int[nums.length];
        int[] lisMinTail = new int[nums.length];
        lisMinTail[0] = nums[0];
        lis[0] = 1;
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>lisMinTail[len-1]){
                lisMinTail[len] = nums[i];
                len++;
                lis[i] = len;
            }else{
                int idx = binarySearch(lisMinTail, len-1, nums[i]);
                lisMinTail[idx] = nums[i];
                lis[i] = idx+1;
            }
        }
        return lis;
    }
    
    private int binarySearch(int[] nums, int right, int target) {
        int left = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] >= target) return left;
        return right;
    }
    
    private int[] getLisN2(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int omax = 1;
        for(int i=1;i<nums.length;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j] && max<lis[j]){
                    max = lis[j];
                }
                if(max==omax){
                    break;
                }
            }
            lis[i] = max+1;
            omax = Math.max(omax, lis[i]);
        }
        return lis;
    }
    
    private void reverse(int[] nums){
        int st = 0, ed = nums.length-1;
        while(st<ed){
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }
    
    private int getMinimumRemovals(int[] lis, int[] lds) {
        int len = 0;
        for(int i=0;i<lis.length;i++){
            //System.out.println(i+": "+lis[i]+" "+lds[i]);
            if(lis[i]>1 && lds[lis.length-1-i]>1){
                len = Math.max(len, lis[i]+lds[lis.length-1-i]-1);
            }
        }
        return lis.length-len;
    }
}