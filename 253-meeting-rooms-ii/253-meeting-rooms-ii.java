class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        //return minMeetingRoomsUsingPriorityQueue(intervals);
        return minMeetingRoomsUsingChronologicalOrdering(intervals);
    }
    
    private int minMeetingRoomsUsingChronologicalOrdering(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for(int i=0;i<n;i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        int rooms = 0;
        int sPtr = 0, ePtr = 0;
        while(sPtr<n){
            if(startTime[sPtr]>=endTime[ePtr]){
                rooms--;
                ePtr++;
            }
            
            rooms++;
            sPtr++;
        }
        
        return rooms;
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