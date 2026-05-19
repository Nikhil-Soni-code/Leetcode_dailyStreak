class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        for(int i=0 ; i<nums2.length ; i++){
            set.add(nums2[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<nums1.length ; i++){
            if(set.contains(nums1[i])){
                ans = Math.min(ans,nums1[i]);
            }
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}