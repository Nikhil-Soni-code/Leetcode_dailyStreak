class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack();
        for(int i=heights.length-1;i>=0;i--){
            int count = 0;
            while(!stack.empty()&&stack.peek()<heights[i]){
                count++;
                stack.pop();
            }
            if(!stack.empty()){
                count++;
            }
            stack.push(heights[i]);
            ans[i] = count;
        }
        return ans;
    }
}