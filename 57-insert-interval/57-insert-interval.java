class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean used  = false;
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<intervals.length;i++){
            if(!used){
                if(intervals[i][0]>newInterval[0]){
                    updateStack(st, newInterval);
                    updateStack(st, intervals[i]);
                    used = true;
                }else{
                    updateStack(st, intervals[i]);
                }
            }else{
                updateStack(st, intervals[i]);
            }
        }
        if(!used){
            updateStack(st, newInterval);
        }
        int[][] res = new int[st.size()][2];
        while(!st.isEmpty()){
            res[st.size()-1] = st.pop();
        }
        return res;
    }
    
    private void updateStack(Stack<int[]> st, int[] interval){
        if(st.isEmpty() || st.peek()[1]<interval[0]){
            st.push(interval);
        }else if(st.peek()[1]<interval[1]){
            st.peek()[1] = interval[1];
        }
    }
}