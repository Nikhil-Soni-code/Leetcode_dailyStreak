class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int sum = 0;
        int maxSum = 0;
        int start=0;
        int end=0;
        while(end<nums.length){
            if(!set.contains(nums[end])){
                sum+=nums[end];
                set.add(nums[end]);
                end++;
            }
            else{
                maxSum = Math.max(maxSum,sum);
                while(start<end&&set.contains(nums[end])){
                    sum-=nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            }
        }
                maxSum = Math.max(maxSum,sum);

        return maxSum;

    }
}