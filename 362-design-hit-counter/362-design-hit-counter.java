class HitCounter {

    Queue<Pair<Integer, Integer>> que;
    int counter;
    public HitCounter() {
        que = new LinkedList<>();
        counter = 0;
    }
    
    public void hit(int timestamp) {
        if(!que.isEmpty() && (int)que.peek().getKey() == timestamp){
            Pair<Integer, Integer> pair = que.poll();
            que.add(new Pair(timestamp, pair.getValue() + 1));
        }else{
            que.add(new Pair(timestamp, 1));
        }
        
        counter++;
    }
    
    public int getHits(int timestamp) {
        while(!que.isEmpty() && timestamp - que.peek().getKey()>=300){
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