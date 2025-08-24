class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int count=0;
        int maxCount = 0;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0){
                count++;
            }
            while(count>k){
                if(nums[i]==0)count--;
                i++;
            }
            maxCount = Math.max(maxCount,j-i+1);
        }


        return maxCount;
    }
}