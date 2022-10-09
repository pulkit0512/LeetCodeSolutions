class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        //return minMeetingRoomsUsingPriorityQueue(intervals);
        return minMeetingRoomsUsingChronologicalOrdering(intervals);
    }
    
    private int minMeetingRoomsUsingChronologicalOrdering(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int stPtr = 0, edPtr = 0;
        int rooms = 0, ans = 0;
        
        while(stPtr<n && edPtr<n) {
            if(start[stPtr]<end[edPtr]){
                rooms++;
                stPtr++;
            }else{
                rooms--;
                edPtr++;
            }
            ans = Math.max(ans, rooms);
        }
        
        return ans;
    }
    
    private int minMeetingRoomsUsingPriorityQueue(int[][] intervals) {
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