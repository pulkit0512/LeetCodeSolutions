class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            if(toBeRemoved[0]>=intervals[i][1] || toBeRemoved[1]<=intervals[i][0]){
                List<Integer> cur = new ArrayList<>();
                cur.add(intervals[i][0]);
                cur.add(intervals[i][1]);
                res.add(cur);
            }else{
                if(toBeRemoved[0]>intervals[i][0] && toBeRemoved[1]<intervals[i][1]){
                    List<Integer> left = new ArrayList<>();
                    left.add(intervals[i][0]);
                    left.add(toBeRemoved[0]);
                    
                    List<Integer> right = new ArrayList<>();
                    right.add(toBeRemoved[1]);
                    right.add(intervals[i][1]);
                    
                    res.add(left);
                    res.add(right);
                }else if(toBeRemoved[0]>intervals[i][0] && toBeRemoved[0]<intervals[i][1] && toBeRemoved[1]>=intervals[i][1]){
                    List<Integer> left = new ArrayList<>();
                    left.add(intervals[i][0]);
                    left.add(toBeRemoved[0]);
                    
                    res.add(left);
                }else if(toBeRemoved[1]>intervals[i][0] && toBeRemoved[1]<intervals[i][1] && toBeRemoved[0]<=intervals[i][0]){
                    List<Integer> right = new ArrayList<>();
                    right.add(toBeRemoved[1]);
                    right.add(intervals[i][1]);
                    
                    res.add(right);
                }
            }
        }
        
        return res;
    }
}