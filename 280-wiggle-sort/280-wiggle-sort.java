class Solution {
    public void wiggleSort(int[] nums) {
        int dir = 0; // 0 indicates next element should be greater and 1 indicates next element should be smaller.
        for(int i=0;i<nums.length-1;i++){
            if(dir==0){
                if(nums[i]>nums[i+1]){
                    swap(nums, i, i+1);
                }
            }else {
                if(nums[i]<nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
            dir = 1-dir;
        }
    }
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}