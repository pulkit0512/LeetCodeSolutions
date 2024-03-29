class Solution {
    public int trap(int[] height) {
        //return trapNSpace(height);
        return trapConstantSpace(height);
    }
    
    // O(1) Space using extreme pointers
    private int trapConstantSpace(int[] height) {
        int left = 0, right = height.length-1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while(left<=right){
            if(height[left]<height[right]) {
                if(height[left]>=left_max){
                    left_max = height[left];
                }else{
                    ans += left_max - height[left];
                }
                left++;
            }else{
                if(height[right]>=right_max){
                    right_max = height[right];
                }else{
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
    
    // O(N) Space
    private int trapNSpace(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i], left[i-1]);
            right[n-1-i] = Math.max(height[n-1-i], right[n-i]);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}