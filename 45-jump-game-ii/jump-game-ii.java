class Solution {
    public int jump(int[] nums) {
        int l = 0,r = 0;
        int count=0;
        while(r<nums.length-1){
            int farthestPoint = 0;
            for(int j=l;j<=r;j++){
                farthestPoint = Math.max(nums[j]+j,farthestPoint);
            }
            l = r+1;
            r = farthestPoint;
            count++;
        }
        return count;
    }
}