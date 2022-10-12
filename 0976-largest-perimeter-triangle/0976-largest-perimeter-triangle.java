class Solution {
    public int largestPerimeter(int[] nums) {
        // a+b>c, a+c>b, b+c>a
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=2;i--){
            int sum = nums[i] + nums[i-1] + nums[i-2];
            
            // a<=b<=c if a+b>c then all three combinations will be satisfied. Since of two smaller side is greater then
            // then third side.
            if(nums[i-1] + nums[i-2] > nums[i]) {
                return sum;
            }
        }
        
        return 0;
    }
}