class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0;
        int ans = Integer.MAX_VALUE;
        for(i=0;i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target)return sum;
                if(Math.abs(sum-target)<Math.abs(target-ans)){
                    ans = sum;
                }
                if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }return ans;
    }
}