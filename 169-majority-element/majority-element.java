class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maxElement = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==maxElement){
                count++;
            }else{
                count--;
            }if(count==0){
                count=1;
                maxElement = nums[i];
            }
        }
        return maxElement;
    }
}