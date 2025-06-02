class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1,suffix = 1,maxPro = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            prefix*=nums[i];
            suffix*=nums[nums.length-1-i];
            maxPro = Math.max(maxPro,prefix);
            maxPro = Math.max(maxPro,suffix);
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
        }
        return maxPro;
    }
}