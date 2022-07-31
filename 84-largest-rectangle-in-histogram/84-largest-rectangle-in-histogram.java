class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st = new Stack<>();
        int max=0,i=0;
        for(i=0;i<n;){
            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
                st.push(i);
                i++;
            }
            else{
                while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int ht=heights[st.pop()];
                int idx=0;
                if(st.isEmpty()){
                    idx=i;
                }
                else{
                    idx=i-st.peek()-1;
                }
                max=Math.max(max,ht*idx);
                }
                st.push(i);
                i++;
            }
        }
        while(!st.isEmpty()){
            int ht=heights[st.pop()];
            int idx=0;
            if(st.isEmpty())
                idx=i;
            else
                idx=i-st.peek()-1;
            max=Math.max(max,ht*idx);
        }
        return max;
    }
}