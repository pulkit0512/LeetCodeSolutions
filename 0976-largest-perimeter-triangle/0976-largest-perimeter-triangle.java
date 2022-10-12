class Solution {
    public int largestPerimeter(int[] nums) {
        // a+b>c, a+c>b, b+c>a
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=2;i--){
            int sum = nums[i] + nums[i-1] + nums[i-2];
            
            /*if(nums[i] == nums[i-1] && nums[i-1] == nums[i-2]){
                // Equilateral triangle.
                return sum;
            }else if((nums[i] == nums[i-1]) || ((nums[i-1] == nums[i-2]) && (nums[i-1] + nums[i-2] > nums[i]))) {
                // isosceles triangle
                return sum;
            }else if(nums[i] + nums[i-1] > nums[i-2] 
                     && nums[i] + nums[i-2] > nums[i-1] 
                     && nums[i-1] + nums[i-2] > nums[i]) {
                // scalene triangle
                return sum;
            }*/
            
            if(nums[i-1] + nums[i-2] > nums[i]) {
                return sum;
            }
        }
        
        return 0;
    }
}