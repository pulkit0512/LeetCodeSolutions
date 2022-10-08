class MyCalendarThree {

    //O(N^2) using boundary count method
    //when a new event arrived increased the value of start by 1 and decrese value of end by 1
    //This will balance out the event
    //While traversing the values of the map, find the max sum of value
    //which will indicate maximum overlapping bookings till now.
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        
        int active=0, ans=0;
        for(int val:map.values()){
            active += val;
            if(active>ans){
                ans = active;
            }
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */