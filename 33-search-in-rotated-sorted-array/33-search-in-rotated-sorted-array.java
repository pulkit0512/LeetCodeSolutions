class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        //System.out.println(pivot);
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0] && target<nums[pivot]){
            int left = Arrays.binarySearch(nums, 0, pivot, target);
            return left>=0?left:-1;
        }else{
            int right = Arrays.binarySearch(nums, pivot+1, nums.length, target);
            return right>=0?right:-1;
        }
    }
    
    private int findPivot(int[] nums) {
        int st = 1, ed = nums.length-2;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[st]>nums[mid]){
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        return 0;
    }
}