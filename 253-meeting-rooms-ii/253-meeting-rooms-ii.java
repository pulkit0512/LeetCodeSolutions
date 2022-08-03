class Solution {
    class sort implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            if(!pq.isEmpty() && intervals[i][0]>=pq.peek()){
                pq.poll();
            }
            
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}