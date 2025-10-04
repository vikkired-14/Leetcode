class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if(minHeap.size()> maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        if(minHeap.size()< maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }else if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */