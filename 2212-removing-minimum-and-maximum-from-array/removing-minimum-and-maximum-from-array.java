class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }
        if(maxIdx<minIdx){
            int way1 = maxIdx+1+nums.length-minIdx;
            int way2 = 1+minIdx;
            int way3 = nums.length-maxIdx;



            return Math.min(way1,Math.min(way2,way3));

        }//first index is nearer
        else{
            int way1 = minIdx+1+nums.length-maxIdx;
            int way2 = 1+maxIdx;
            int way3 = nums.length-minIdx;



            return Math.min(way1,Math.min(way2,way3));
        }
    }
}