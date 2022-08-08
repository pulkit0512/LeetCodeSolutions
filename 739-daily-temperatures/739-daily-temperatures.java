class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //return dailyTemperaturesNSpace(temperatures);
        return dailyTemperaturesConstantSpace(temperatures);
    }
    
    private int[] dailyTemperaturesConstantSpace(int[] temperatures) {
        int hottest = 0;
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int curDay=n-1;curDay>=0;curDay--){
            if(temperatures[curDay]>=hottest){
                hottest = temperatures[curDay];
            }else{
                int day = 1;
                while(temperatures[curDay+day]<=temperatures[curDay]){
                    day += ans[curDay+day];
                }
                ans[curDay] = day;
            }
        }
        return ans;
    }
    
    private int[] dailyTemperaturesNSpace(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {
                ans[st.peek()] = i-st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()] = 0;
        }
        return ans;
    }
}