class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        Stack<int[]> st = new Stack<>();
        for(int[] interval:intervals){
            if(st.isEmpty() || st.peek()[1]<interval[0]){
                st.push(interval);
            }else{
                if(st.peek()[1]<interval[1]){
                    st.peek()[1] = interval[1];
                }
            }
        }
        int[][] ans = new int[st.size()][2];
        int size = st.size();
        for(int i=size-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}