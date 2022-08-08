class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty() || temperatures[st.peek()]>=temperatures[i]){
                st.push(i);
            }else{
                while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {
                    ans[st.peek()] = i-st.pop();
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            ans[st.pop()] = 0;
        }
        return ans;
    }
}