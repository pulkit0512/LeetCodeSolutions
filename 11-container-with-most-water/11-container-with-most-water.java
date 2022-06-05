class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int st = 0, ed = height.length-1;
        while(st<ed){
            ans = Math.max(ans, (ed-st)*Math.min(height[st], height[ed]));
            if(height[st]<height[ed]){
                st++;
            }else{
                ed--;
            }
        }
        return ans;
    }
}