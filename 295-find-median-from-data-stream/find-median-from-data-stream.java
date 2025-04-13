class MedianFinder {
    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;

    public MedianFinder() {
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
        minPq = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        if(maxPq.size()==0){
            maxPq.add(num);
            return;
        }
        if(maxPq.peek()<num){
            minPq.add(num);
            if(minPq.size()>maxPq.size()){
                maxPq.add(minPq.poll());
            }
        }else{
            maxPq.add(num);
            if(maxPq.size()-minPq.size()>1){
                minPq.add(maxPq.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxPq.size()==minPq.size()){
            double ans = (double)(maxPq.peek()+minPq.peek())/2.0;
            return ans;
        }else{
            return maxPq.peek()*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */