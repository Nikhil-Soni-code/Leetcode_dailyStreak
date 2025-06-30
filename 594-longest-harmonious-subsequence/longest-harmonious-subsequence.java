class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int max = 0;
        for(int j=0;j<nums.length;j++){
            while(nums[j]-nums[i]>1){
                i++;
            }
            max = (nums[j]-nums[i]==1)?Math.max(max,j-i+1):max;
        }
        return max;
    }
}