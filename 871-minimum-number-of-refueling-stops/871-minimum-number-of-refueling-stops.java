class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> capacity = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0, prevStop = 0;
        for(int[] station:stations){
            startFuel = startFuel - (station[0]-prevStop);
            while(!capacity.isEmpty() && startFuel<0){
                startFuel += capacity.poll();
                stops++;
            }
            if(startFuel<0){
                return -1;
            }
            capacity.add(station[1]);
            prevStop = station[0];
        }
        startFuel = startFuel - (target-prevStop);
        while(!capacity.isEmpty() && startFuel<0){
            startFuel += capacity.poll();
            stops++;
        }
        return startFuel<0?-1:stops;
    }
}