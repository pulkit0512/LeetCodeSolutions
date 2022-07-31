class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(-1);
        for(int i=0;i<n;i++){
            if(st.size()==1 || heights[i]>=heights[st.peek()]){
                st.push(i);
            }else{
                while(st.size()>1 && heights[i]<heights[st.peek()]){
                    int ht = heights[st.pop()];
                    int wt = i-st.peek()-1;
                    max = Math.max(max, ht*wt);
                }
                st.push(i);
            }
        }
        while(st.size()>1){
            int ht = heights[st.pop()];
            int wt = n-st.peek()-1;
            max = Math.max(max, ht*wt);
        }
        
        return max;
    }
}