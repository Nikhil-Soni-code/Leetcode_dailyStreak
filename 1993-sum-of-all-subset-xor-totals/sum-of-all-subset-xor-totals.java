class Solution {
    int xor = 0;
    public void subSet(List subset,int []nums,int i){
        if(i==nums.length){
            xor+=findXor(subset);
            return;
        }
        subset.add(nums[i]);
        subSet(subset,nums,i+1);
        subset.remove(subset.size()-1);
        subSet(subset,nums,i+1);

    }
    private int findXor(List<Integer> subset){
        int xor = 0;
        for(Integer i:subset){
            xor^=i;
        }
        return xor;
    }
    public int subsetXORSum(int[] nums) {
        subSet(new ArrayList(),nums,0);
        return xor;
    }
    
}