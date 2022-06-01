class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = getLis(nums);
        int[] lds = getLds(nums);
        
        int len = 0;
        for(int i=0;i<nums.length;i++){
            if(lis[i]>1 && lds[i]>1){
                len = Math.max(len, lis[i]+lds[i]-1);
            }
        }
        return nums.length-len;
    }
    
    private int[] getLis(int[] nums) {
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
    
    private int[] getLds(int[] nums) {
        int[] lds = new int[nums.length];
        lds[nums.length-1] = 1;
        int omax = 1;
        for(int i=nums.length-2;i>=0;i--){
            int max = 0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j] && max<lds[j]){
                    max = lds[j];
                }
                if(max==omax){
                    break;
                }
            }
            lds[i] = max+1;
            omax = Math.max(omax, lds[i]);
        }
        return lds;
    }
}