/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(List<Interval> emp:schedule) {
            int prev = Integer.MIN_VALUE;
            for(Interval in:emp) {
                map.put(prev, map.getOrDefault(prev, 0) + 1);
                map.put(in.start, map.getOrDefault(in.start, 0) - 1);
                
                prev = in.end;
            }
            
            map.put(prev, map.getOrDefault(prev, 0) + 1);
            map.put(Integer.MAX_VALUE, map.getOrDefault(Integer.MAX_VALUE, 0) - 1);
        }
        
        //System.out.println(map);
        
        List<Interval> result = new ArrayList<>();
        int st = -1;
        int free = 0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            free += entry.getValue();
            
            // This indicates all employees are free, starting from this time.
            // Since we can include infinite in our answer so included 2nd condition.
            if(free == schedule.size() && entry.getKey()!=Integer.MIN_VALUE) {
                st = entry.getKey();
            }else if(st!= -1 && free != schedule.size() && entry.getKey() != Integer.MAX_VALUE) {
                // If we found the start of an interval indicating all employees were free and then
                // at this time one or more employees gets busy. So interval ends here.
                // reset the start.
                result.add(new Interval(st, entry.getKey()));
                st = -1;
            }
        }
        
        return result;
    }
}