class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int i=0, j=0 ; 
        while(i<pushed.length || j<popped.length){
            if(i<pushed.length){
                stack.push(pushed[i]);
                i++;
            }
            while(!stack.isEmpty() && popped[j]==stack.peek()){
                stack.pop();
                j++;
            }
            if(i==pushed.length && j==popped.length)return true;
            if(i==pushed.length && !stack.isEmpty() &&stack.peek() != popped[j])return false;
        }return true;
    }
}