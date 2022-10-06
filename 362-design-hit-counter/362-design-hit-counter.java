class HitCounter {

    Queue<Pair<Integer, Integer>> que;
    int counter;
    public HitCounter() {
        que = new LinkedList<>();
        counter = 0;
    }
    
    public void hit(int timestamp) {
        counter++;
        if(que.isEmpty() || que.peek().getKey()<timestamp) {
            que.add(new Pair(timestamp, 1));
        }else{
            que.add(new Pair(timestamp, que.poll().getValue() + 1));
        }
    }
    
    public int getHits(int timestamp) {
        while(!que.isEmpty() && que.peek().getKey()<=timestamp-300){
            counter -= que.poll().getValue();
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