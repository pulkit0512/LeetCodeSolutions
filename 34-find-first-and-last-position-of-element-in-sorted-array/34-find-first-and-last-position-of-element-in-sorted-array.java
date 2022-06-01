class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        if(nums.length==0){
            return range;
        }
        int idx = binarySearch(nums, 0, nums.length-1, target);
        if(idx==-1){
            return range;
        }
        range[0] = idx;
        range[1] = idx;
        int x1 = idx, x2 = idx;
        while(x1!=-1 || x2!=-1){
            if(x1!=-1){
                x1 = binarySearch(nums, 0, x1-1, target);
                if(x1!=-1){
                    range[0] = x1;
                }
            }
            if(x2!=-1){
                x2 = binarySearch(nums, x2+1, nums.length-1, target);
                if(x2!=-1){
                    range[1] = x2;
                }
            }
        }
        
        return range;
    }
    
    private int binarySearch(int nums[], int st, int ed, int target) {
        while(st<=ed){
            int mid = (st+ed)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        return -1;
    }
}