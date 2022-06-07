class HitCounter {

    class Pair{
        int time, cnt;
        public Pair(int time, int cnt){
            this.time = time;
            this.cnt = cnt;
        }
    }
    Queue<Pair> hits;
    int counter;
    public HitCounter() {
        hits = new LinkedList<>();
        counter = 0;
    }
    
    public void hit(int timestamp) {
        if(!hits.isEmpty() && hits.peek().time==timestamp){
            hits.peek().cnt++;
        }else{
            hits.add(new Pair(timestamp, 1));
        }
        counter++;
    }
    
    public int getHits(int timestamp) {
        while(!hits.isEmpty() && hits.peek().time<=timestamp-300){
            counter -= hits.poll().cnt;
        }
        return counter;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */