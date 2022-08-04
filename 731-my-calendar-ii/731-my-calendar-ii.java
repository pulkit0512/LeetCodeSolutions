class MyCalendarTwo {

    //O(N^2) brute force created event and 2booking list and used 2 booking list to check for 3rd booking
    //if found return false
    //used event list two update two booking list if any overlapping found with start as max of both events start
    // and end as min of events min
    // update event list
    /*List<int[]> events;
    List<int[]> twoBookings;
    public MyCalendarTwo() {
        events = new ArrayList<>();
        twoBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        //Check 3-booking using twoBookings list
        for(int[] booking:twoBookings){
            if(booking[1]>start && booking[0]<end){
                return false;
            }
        }
        
        //If any two booking update two booking list
        for(int[] event:events){
            if(event[1]>start && event[0]<end){
                twoBookings.add(new int[]{Math.max(event[0], start), Math.min(event[1], end)});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }*/
    
    //O(N^2) using boundary count method
    //when a new event arrived increased the value of start by 1 and decrese value of end by 1
    //This will balance out the event
    //At any point while traversing over the sorted keys sum of values is >=3 then there is a triple booking for
    // for that instance
    // update the map by decreasing value of start key and increasing value of end key. Return false
    // else return true
    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        
        int activeEvents = 0;
        for(int val:map.values()){
            activeEvents += val;
            if(activeEvents>=3){
                map.put(start, map.get(start)-1);
                map.put(end, map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */