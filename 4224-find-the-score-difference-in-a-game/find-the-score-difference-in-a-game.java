class Solution {
    public int scoreDifference(int[] nums) {
        boolean flag = true;
        int active = 0,inActive = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] % 2 == 1)flag = !flag;
            if(i%6 == 5)flag = !flag;

            if(flag)active+=nums[i];
            else inActive+=nums[i];

        }return active-inActive;
    }
}