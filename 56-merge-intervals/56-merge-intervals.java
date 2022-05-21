class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Stack<int[]> st = new Stack<>();
        for(int[] interval:intervals){
            if(st.isEmpty()){
                st.push(interval);
            }else if(interval[0]<=st.peek()[1]){
                if(interval[1]>st.peek()[1]){
                    st.peek()[1] = interval[1];
                }
            }else{
                st.push(interval);
            }
        }
        int[][] ans = new int[st.size()][2];
        for(int i=st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}