class Solution {
    public int findDuplicate(int[] nums) {
        //return findDuplicateCyclicSort(nums);
        return findDuplicateNegativeMarking(nums);
    }
    
    private int findDuplicateNegativeMarking(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(nums[val]<0){
                return val;
            }
            nums[val] = -nums[val];
        }
        return n;
    }
    
    private int findDuplicateCyclicSort (int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]!=nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return nums[i];
            }
        }
        return n;
    }
}