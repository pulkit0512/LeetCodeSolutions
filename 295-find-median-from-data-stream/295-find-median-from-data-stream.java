class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty()){
            minHeap.add(num);
        }else if(num<=minHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        if(minHeap.size() == maxHeap.size() + 2){
            maxHeap.add(minHeap.poll());
        }else if(minHeap.size() + 2 == maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */