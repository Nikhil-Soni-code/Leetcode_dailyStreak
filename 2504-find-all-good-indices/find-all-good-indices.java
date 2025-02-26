class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList();
        if(nums.length<=1){
            return ans;
        }
        int[] decr = new int[nums.length];
        decr[0]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                decr[i] = decr[i-1]+1;
            }
        }

        int[] incr = new int[nums.length];
        incr[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                incr[i] = incr[i+1]+1;
            }
        }
        for(int i=k;i<nums.length-k;i++){
            if(decr[i-1]-decr[i-k]==k-1&&incr[i+1]-incr[i+k]==k-1){
                ans.add(i);
            }
        }
        return ans;

    }
}