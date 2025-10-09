class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashSet<Integer> set = new HashSet();
        int sum = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==target||set.contains(sum-target)){
                ans++;
                set.clear();
                sum = 0;
            }
            set.add(sum);
        }
        return ans;
    }
}