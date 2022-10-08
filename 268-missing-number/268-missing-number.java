class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = IntStream.of(nums).sum();
        int total = (n*(n+1))/2;
        
        return total-sum;
    }
}