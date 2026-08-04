class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList();
        Arrays.sort(nums);
        int prev = nums[0];
        int i=1;
        while(i<nums.length){
            if(nums[i]!=prev+1){
                ans.add(prev+1);
                prev = prev+1;
            }else{
                prev = nums[i++];
            }
        }return ans;
    }
}