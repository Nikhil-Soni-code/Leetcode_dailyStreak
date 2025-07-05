class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int[][] pair = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            pair[i][0] = i;
            pair[i][1] = nums[i];
        }
        Arrays.sort(pair,(a,b)->b[1]-a[1]);
        int[][] pair2 = new int[k][2];
        for(int i=0;i<k;i++){
            pair2[i][0] = pair[i][0];
            pair2[i][1] = pair[i][1];
        }
        Arrays.sort(pair2,(a,b) -> a[0]-b[0]);
        for(int i=0;i<k;i++){
            ans[i] = pair2[i][1];
        }
        return ans;



    }
}