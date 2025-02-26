class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum1 = 0;
        
        
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            maxSum1 = Math.max(maxSum1,Math.abs(currSum));
            if(currSum<0){
                currSum=0;
            }
        }
        int maxSum2 = 0;
        currSum=0;

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            maxSum2 = Math.max(maxSum2,Math.abs(currSum));
            if(currSum>0){
                currSum=0;
            }
        }
        return (maxSum1>maxSum2)?maxSum1:maxSum2;
    }
}