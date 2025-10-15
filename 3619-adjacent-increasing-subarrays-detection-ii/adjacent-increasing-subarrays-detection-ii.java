class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prevRun = 0;
        int k = 1;
        int currCount = 1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)<nums.get(i)){

                currCount++;
            k = Math.max(currCount/2,k);

            }else{
                k = Math.max(k,Math.min(prevRun,currCount));
                prevRun = currCount;
                currCount=1;
            }
        }
        k = Math.max(k,Math.min(prevRun,currCount));
        return k;
    }
}