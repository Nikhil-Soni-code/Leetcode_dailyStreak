class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotateArray(nums,0,nums.length-1);
        rotateArray(nums,0,k-1);
        rotateArray(nums,k,nums.length-1);


    }
    private void rotateArray(int[] nums,int beg,int end){
        while(beg<end){
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;end--;
        }
    }
}