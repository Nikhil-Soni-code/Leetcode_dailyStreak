class Solution {
    int[] original;
    public Solution(int[] nums) {
        original = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            original[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int[]shuffled = new int[original.length];
        for(int i=0;i<original.length;i++){
            shuffled[i] = original[i];
        }
        for(int i=0;i<original.length;i++){
            swap(shuffled,i,(int)(Math.random()*10)%original.length);
        }
        return shuffled;
    }
    private void swap(int[] s,int i,int r){
        int temp =  s[i];
        s[i] = s[r];
        s[r] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */