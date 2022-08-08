class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0;
        int prevStop = 0;
        for(int[] station:stations) {
            startFuel -= (station[0]-prevStop);
            while(!fuel.isEmpty() && startFuel<0){
                startFuel += fuel.poll();
                stops++;
            }
            if(startFuel<0){
                return -1;
            }
            
            fuel.add(station[1]);
            prevStop = station[0];
        }
        startFuel -= (target-prevStop);
        while(!fuel.isEmpty() && startFuel<0){
            startFuel += fuel.poll();
            stops++;
        }
        return startFuel>=0?stops:-1;
    }
}