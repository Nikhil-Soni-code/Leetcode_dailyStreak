class Solution {
    public int findKthLargest(int[] nums, int k) {
        //O(n*logn)

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//bydefault: minHeap
        // for(int i=0;i<nums.length;i++){
        //     pq.add(nums[i]);
        // }
        // while(k!=1){
        //     pq.poll();
        //     k--;
        // }
        // return pq.poll();
        PriorityQueue<Integer> pq = new PriorityQueue<>();//bydefault: minHeap
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }return pq.poll();


    }
}