class MyCalendar {

    // O(NLogN) Solution
    TreeMap<Integer, Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prevBooking = bookings.floorEntry(start);
        Map.Entry<Integer, Integer> nextBooking = bookings.ceilingEntry(start);
        
        if((prevBooking==null || prevBooking.getValue()<=start) && (nextBooking==null || nextBooking.getKey()>=end)){
            bookings.put(start, end);
            return true;
        }else{
            return false;
        }
    }
    
    // O(N^2)solution
    /*class pair{
        int st,ed;
        pair(int a, int b){
            st = a;
            ed = b;
        }
    }
    class sort implements Comparator<pair>{
        public int compare(pair a, pair b){
            if(a.st==b.st){
                return a.ed-b.ed;
            }
            return a.st - b.st;
        }
    }

    TreeSet<pair> set;
    public MyCalendar() {
        set = new TreeSet(new sort());
    }
    
    public boolean book(int start, int end) {
        pair newPair = new pair(start, end);
        //System.out.println(set+" "+start+" "+end);
        for(pair p:set){
            if(p.st>=start && p.ed<=end){
                return false;
            }
            if(start>=p.st && end<=p.ed){
                return false;
            }
            if(p.st>=start && end<=p.ed && end>p.st){
                return false;
            }
            if(start>=p.st && p.ed<=end && p.ed>start){
                return false;
            }
        }
        set.add(newPair);
        return true;
    }*/
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */