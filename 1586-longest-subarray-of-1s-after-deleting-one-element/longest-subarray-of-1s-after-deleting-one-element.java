class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int length = 0;
        int zeroCount = 0;
        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
            }
            while(i<=j&&zeroCount>1){
                if(nums[i]==0)zeroCount--;
                i++;
            }
            length = Math.max(length,j-i); 
            j++;
        }
        
        return length;
    }
}