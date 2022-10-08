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
            for(Interval in:emp) {
                map.put(in.start, map.getOrDefault(in.start, 0) + 1);
                map.put(in.end, map.getOrDefault(in.end, 0) - 1);
            }
        }
        
        //System.out.println(map);
        
        List<Interval> result = new ArrayList<>();
        int st = -1;
        int free = 0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            free += entry.getValue();
            
            // This indicates all employees are free, starting from this time.
            // Since we can include infinite in our answer so included 2nd condition.
            if(free == 0) {
                st = entry.getKey();
            }else if(st!= -1 && free != 0) {
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