class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> tempAns = new ArrayList<>();
        int max = 0;
        for(int i=heights.length-1;i>=0;i--){
            if(heights[i]>max){
                tempAns.add(i);
                max = heights[i];
            }
        }
        int[] ans = new int[tempAns.size()];
        int idx = tempAns.size()-1;
        for(int x:tempAns){
            ans[idx--] = x;
        }
        return ans;
    }
}