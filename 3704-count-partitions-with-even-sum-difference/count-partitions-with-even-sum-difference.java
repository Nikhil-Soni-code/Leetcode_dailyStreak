class Solution {
    public int countPartitions(int[] nums) {
        int suffixSum = 0;
        for(int i=0;i<nums.length;i++)suffixSum+=nums[i];
        int partitions = 0;
        int prefixSum = 0;
        for(int i=0;i<nums.length-1;i++){
            prefixSum+=nums[i];
            suffixSum-=nums[i];
            if(Math.abs(prefixSum-suffixSum)%2==0)partitions+=1;
        }
        return partitions;
    }
}