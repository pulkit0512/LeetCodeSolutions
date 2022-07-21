class Solution {
    public int maxArea(int[] height) {
        int st = 0, ed = height.length-1;
        int ans = 0;
        while(st<ed){
            ans = Math.max(ans, Math.min(height[st], height[ed])*(ed-st));
            if(height[st]<height[ed]){
                st++;
            }else{
                ed--;
            }
        }
        return ans;
    }
}