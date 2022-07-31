class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsLeft = new int[n];
        int[] nsRight = new int[n];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                    nsRight[st.pop()] = i;
                }
                st.push(i);
            }
            
            if(st1.isEmpty() || heights[n-1-i]>=heights[st1.peek()]){
                st1.push(n-1-i);
            }else{
                while(!st1.isEmpty() && heights[n-1-i]<heights[st1.peek()]){
                    nsLeft[st1.pop()] = n-1-i;
                }
                st1.push(n-1-i);
            }
        }
        while(!st.isEmpty()){
            nsRight[st.pop()] = n;
        }
        
        while(!st1.isEmpty()){
            nsLeft[st1.pop()] = -1;
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, (nsRight[i] - nsLeft[i] - 1)*heights[i]);
        }
        
        return ans;
    }
}