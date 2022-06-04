class Solution {
    class sort implements Comparator<int[]> {
        public int compare(int a[], int b[]) {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Stack<int[]> st = new Stack<>();
        Arrays.sort(intervals, new sort());
        for(int[] interval:intervals){
            if(st.isEmpty()){
                st.push(interval);
            }else if(st.peek()[0]<=interval[0] && st.peek()[1]>=interval[1]){
                continue;
            }else{
                st.push(interval);
            }
        }
        return st.size();
    }
}