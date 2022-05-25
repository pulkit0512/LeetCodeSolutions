class Solution {
    public int lengthOfLIS(int[] nums) {
        //return lengthOfLisN2(nums);
        return lengthOfLisNLogN(nums);
    }
    
    private int lengthOfLisN2(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int lis[] = new int[n];
        lis[0] = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    max = Math.max(max, lis[j]);
                }
                if(max==ans){
                    break;
                }
            }
            lis[i] = max+1;
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }
    
    private int lengthOfLisNLogN(int[] nums) {
        int n = nums.length;
		int tail[] = new int[n];
		tail[0] = nums[0];
		int length = 1;
		for(int i=1;i<n;i++){
			if(nums[i]>tail[length-1]){
				tail[length] = nums[i];
				length++;
			} else {
				int idx = Arrays.binarySearch(tail, 0, length-1, nums[i]);
				if(idx<0){
					idx = -(idx + 1);
				}
				tail[idx] = nums[i];
			}
		}
        return length;
    }
}