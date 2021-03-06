class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length-1;
        for(int i=0;i<=two;){
            if(nums[i]==0){
                swap(nums, i, zero);
                zero++;
                i++;
            }else if(nums[i]==2){
                swap(nums, i, two);
                two--;
            }else{
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}