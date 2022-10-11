class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<=2){
            return false;
        }
        
        int[] lis = new int[3];
        lis[0] = nums[0];
        int len = 1;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>lis[len-1]){
                lis[len] = nums[i];
                len++;
            }else{
                int idx = 0; // for len 1, 0th index element will only be replaced.
                // len can be 1, 2 in this question. If we reach 3 we would have return true by now.
                if(len==2){
                    if(nums[i]>lis[0]){
                        idx = 1;
                    }else{
                        idx = 0;
                    }
                }
                
                // This works faster for larger subsequences as well in LogN time. Log2 for this question
                /*int idx = Arrays.binarySearch(lis, 0, len, nums[i]);
                if(idx<0){
                    idx = -(idx+1);
                }*/
                
                lis[idx] = nums[i];
            }
            
            if(len==3){
                return true;
            }
        }
        
        return false;
    }
}