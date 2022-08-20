class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int prevStop = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] station:stations) {
            startFuel -= (station[0] - prevStop);
            while(startFuel<0 && !pq.isEmpty()){
                startFuel += pq.poll();
                stops++;
            }
            if(startFuel<0){
                return -1;
            }
            pq.add(station[1]);
            prevStop = station[0];
        }
        startFuel -= (target-prevStop);
        while(startFuel<0 && !pq.isEmpty()){
            startFuel += pq.poll();
            stops++;
        }
        return startFuel<0 ? -1 : stops;
    }
}