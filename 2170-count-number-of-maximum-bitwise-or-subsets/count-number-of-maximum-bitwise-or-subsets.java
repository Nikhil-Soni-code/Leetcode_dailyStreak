class Solution {
    public int subsets(List subset,int i,int[]nums , int maxOr){
        if(i==nums.length){
            if(or(subset , maxOr)){
                return 1;
            }
            return 0;
        }
        subset.add(nums[i]);
        int c1 = subsets(subset , i+1 , nums , maxOr);
        subset.remove(subset.size()-1);
        int c2 = subsets(subset , i+1 , nums , maxOr);
        return c1+c2;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i:nums){
            maxOr = maxOr | i;
        }
        return subsets(new ArrayList() , 0 , nums, maxOr);
    }
    public boolean or(List subset , int maxOr){
        int or = 0;
        for(int i=0;i<subset.size();i++){
            or = or | (int)subset.get(i);
        }
        if(or==maxOr){
            return true;
        }
        return false;
    }
}