class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int culprit = -1;
        int minKIndex = -1;
        int maxKIndex = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK||nums[i]>maxK)culprit = i;
            if(nums[i]==minK)minKIndex = i;
            if(nums[i]==maxK)maxKIndex = i;
            int res = Math.min(minKIndex,maxKIndex)-culprit;
            count+=res<0?0:res;
        }
        return count;
        
    }
}