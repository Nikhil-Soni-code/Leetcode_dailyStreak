class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int negMax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                if(!set.contains(nums[i])){
                    ans+=nums[i];
                    set.add(nums[i]);
                }
            }else{
                negMax = Math.max(negMax,nums[i]);
            }
        }
        return (set.size()==0)?negMax:ans;
    }
}