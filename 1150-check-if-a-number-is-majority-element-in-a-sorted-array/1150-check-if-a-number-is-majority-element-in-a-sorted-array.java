class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int[] range = new int[2];
        int idx = binarySearch(nums, 0, nums.length-1, target);
        if(idx==-1){
            return false;
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
        int count = range[1] - range[0] + 1;
        if(count > (nums.length/2)){
            return true;
        }else{
            return false;
        }
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