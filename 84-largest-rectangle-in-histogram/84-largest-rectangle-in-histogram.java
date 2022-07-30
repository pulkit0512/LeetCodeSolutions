class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsLeft = new int[n];
        int[] nsRight = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                    nsRight[st.pop()] = i;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            nsRight[st.pop()] = n;
        }
        
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                    nsLeft[st.pop()] = i;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            nsLeft[st.pop()] = -1;
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, (nsRight[i] - nsLeft[i] - 1)*heights[i]);
        }
        
        return ans;
    }
}