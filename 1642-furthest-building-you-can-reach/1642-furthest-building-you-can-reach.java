class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
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