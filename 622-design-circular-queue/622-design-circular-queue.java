class MyCircularQueue {

    int[] que;
    int st, ed, k, cnt;
    public MyCircularQueue(int k) {
        que = new int[k];
        Arrays.fill(que, -1);
        st = 0;
        ed = -1;
        cnt = 0;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        
        ed = (ed+1)%k;
        que[ed] = value;
        cnt++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        
        que[st] = -1;
        st = (st+1)%k;
        cnt--;
        return true;
    }
    
    public int Front() {
        return que[st];
    }
    
    public int Rear() {
        return (ed==-1)?-1:que[ed];
    }
    
    public boolean isEmpty() {
        return cnt==0;
    }
    
    public boolean isFull() {
        return cnt==k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */