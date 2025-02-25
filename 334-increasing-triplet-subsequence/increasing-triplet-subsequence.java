class Solution {
    public boolean increasingTriplet(int[] nums) {
        int nums1=Integer.MAX_VALUE;
        int nums2=Integer.MAX_VALUE;


        for(int i=0;i<nums.length;i++){
            if(nums1>=nums[i]){
                nums1 = nums[i];
            }
            else if(nums2>=nums[i]){
                nums2 = nums[i];
            }
            else{
                return true;
            }

        }
        return false;
    }
}