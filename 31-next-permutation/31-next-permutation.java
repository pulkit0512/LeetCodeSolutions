class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return;
        }
        int idx = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums, 0, n-1);
            return;
        }
        int nge = binarySearch(nums, idx+1, n-1, nums[idx]);
        swap(nums, idx, nge);
        reverse(nums, idx+1, n-1);
    }
    
    private void reverse(int nums[], int st, int ed){
        while(st<=ed){
            swap(nums, st, ed);
            st++;
            ed--;
        }
    }
    private void swap(int[] nums, int st, int ed){
        int temp = nums[st];
        nums[st] = nums[ed];
        nums[ed] = temp;
    }
    
    private int binarySearch(int[] nums, int st, int ed, int tar) {
        int idx = ed;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(nums[mid]<=tar){
                ed = mid-1;
            }else{
                st = mid+1;
                idx = mid;
            }
        }
        return idx;
    }
}