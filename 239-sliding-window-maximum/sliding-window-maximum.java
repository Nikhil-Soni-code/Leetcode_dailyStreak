class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        if(k>n)return ans;

        Deque<Integer> deque = new LinkedList();
        int end=0;
        while(end<k){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[end]){
                System.out.println(nums[deque.peekLast()]);
                deque.removeLast();
            }
            deque.addLast(end);

            end++;
        }
        int start=0;
        ans[start]=nums[deque.peekFirst()];
        while(end<n){
            if(deque.peekFirst()==start){
                deque.removeFirst();
            }
            start++;
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[end]){
                deque.removeLast();
            }
            deque.addLast(end);
            ans[start] = nums[deque.peekFirst()];
            end++;
        }
        return ans;
    }
}