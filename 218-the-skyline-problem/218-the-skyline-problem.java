class Solution {
    class BuildingPoint implements Comparable<BuildingPoint> {
        int x, ht;
        boolean isStart;
        
        public BuildingPoint(int x, int ht, boolean isStart) {
            this.x = x;
            this.ht = ht;
            this.isStart = isStart;
        }

        public int compareTo(BuildingPoint other) {
            // If both x are different sort in ascending order of x.
            if(this.x!=other.x){
                return this.x-other.x;
            }else{
                if(this.isStart && other.isStart) {
                    //else if both x are same and are start points then sort in descending order of height
                    //Since larger heights should be processed first while entering the priority queue.
                    //If processed in opposite way max height of priority queue can change for both points
                    //and both points can come in output then.
                    
                    return other.ht-this.ht;
                }else if(!this.isStart && !other.isStart) {
                    //else if both x are same and are end points then sort in ascending order of height
                    //Since smaller heights should be processed first while exiting the priority queue. 
                    //If processed in opposite way max height of priority queue can change for both points
                    //and both points can come in output then.
                    return this.ht - other.ht;
                }else{
                    //else if one is start and other is end point, then preference will be given to start
                    //Else endpoint can also appear in output.
                    
                    if(this.isStart){
                        return -1;
                    }else{
                        return 1;
                    }
                    
                }
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        BuildingPoint[] points = new BuildingPoint[2*n];
        int idx = 0;
        for(int[] building:buildings) {
            points[idx++] = new BuildingPoint(building[0], building[2], true);
            points[idx++] = new BuildingPoint(building[1], building[2], false);
        }
        
        Arrays.sort(points);
        
        /*for(BuildingPoint point:points){
            System.out.println(point.x +" "+point.ht+" "+point.isStart);
        }*/
        
        List<List<Integer>> skyline = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int maxHeight = 0;
        
        for(BuildingPoint point:points) {
            if(point.isStart) {
                // If start point insert the point height in tree map
                map.put(point.ht, map.getOrDefault(point.ht, 0) + 1);
            }else {
                // else remove the point height from tree map.
                int val = map.get(point.ht);
                if(val==1){
                    map.remove(point.ht);
                }else{
                    map.put(point.ht, val-1);
                }
            }
            
            // Get current max height from tree map as last key
            // If current max height and previous max height are not same. Then there is change in height
            // due to this point. Add current point x coordinate with max height in the result.
            int curMaxHeight = map.lastKey();
            if(curMaxHeight!=maxHeight) {
                skyline.add(Arrays.asList(point.x, curMaxHeight));
                maxHeight = curMaxHeight;
            }
        }
        
        return skyline;
    }
}