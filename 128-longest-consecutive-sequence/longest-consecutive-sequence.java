class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxCount = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int count = 1;
                int ele = num;
                while(set.contains(ele+1)){
                    count++;
                    ele++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }return maxCount;
    }
}