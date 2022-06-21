class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //return furthestBuildingUsingMaxHeap(heights, bricks, ladders);
        return furthestBuildingUsingBinarySearch(heights, bricks, ladders);
    }
    
    private int furthestBuildingUsingBinarySearch(int[] heights, int bricks, int ladders) {
        List<int[]> climbs = new ArrayList<>();
        for(int i=1;i<heights.length;i++){
            int diff = heights[i]-heights[i-1];
            if(diff<=0){
                continue;
            }
            climbs.add(new int[]{diff, i});
        }
        Collections.sort(climbs, (a,b)->(a[0]-b[0]));
        int low = 0, high = heights.length-1;
        while(low<high){
            int mid = (low+high+1)/2;
            if(isReachable(mid, climbs, bricks, ladders)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    
    private boolean isReachable(int building, List<int[]> climbs, int bricks, int ladders) {
        for(int i=0;i<climbs.size();i++){
            if(climbs.get(i)[1]>building){
                continue;
            }
            if(bricks-climbs.get(i)[0]>=0){
                bricks -= climbs.get(i)[0];
            }else if(ladders>0){
                ladders--;
            }else{
                return false;
            }
        }
        return true;
    }
    
    private int furthestBuildingUsingMaxHeap(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]<=heights[i-1]){
                idx++;
            }else{
                int diff = heights[i]-heights[i-1];
                //System.out.println(diff+" "+i+" "+bricks+" "+ladders);
                if(diff<=bricks){
                    que.add(diff);
                    bricks -= diff;
                    idx++;
                }else if(ladders>0){
                    if(!que.isEmpty() && bricks + que.peek() - diff >=0){
                        que.add(diff);
                        bricks += que.poll() - diff;
                    }
                    ladders--;
                    idx++;
                }else{
                    break;
                }
                //System.out.println(bricks+" "+ladders);
            }
        }
        return idx;
    }
}