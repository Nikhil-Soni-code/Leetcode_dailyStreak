class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int pro1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int pro2 = nums[0]*nums[1]*nums[nums.length-1];
        return Math.max(pro1,pro2);
    }
}