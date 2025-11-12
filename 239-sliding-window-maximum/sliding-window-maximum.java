class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = deque.peekFirst();
        int j =0;
        for(int i=k;i<nums.length;i++){
            if(deque.peekFirst()==nums[j])deque.pollFirst();
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();
            }

            deque.addLast(nums[i]);
            j++;
            ans[j] = deque.peekFirst(); 

        }
        return ans;
    }
}