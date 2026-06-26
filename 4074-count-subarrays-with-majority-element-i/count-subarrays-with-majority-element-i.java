class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for(int i=0 ; i<nums.length ; i++){
            int targetCount = 0;
            for(int j=i ; j<nums.length ; j++){
                if(target==nums[j])targetCount++;
                if((targetCount*2) > (j-i+1))count++;
            }
        }
        return count;
    }
}