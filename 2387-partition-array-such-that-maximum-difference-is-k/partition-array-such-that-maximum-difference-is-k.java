class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int start=0,end=0;
        int ans=0;
        while(end<nums.length){
            if(nums[end]-nums[start]>k){
                ans++;
                start=end;
                continue;
            }
            end++;
        }
        if(nums[--end]-nums[start]<=k){ans++;}
        return ans;

    }
}