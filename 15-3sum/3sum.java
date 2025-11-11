class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet();
        for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> subAns = new ArrayList();
                    subAns.add(nums[i]);
                    subAns.add(nums[j]);
                    subAns.add(nums[k]);
                    ans.add(new ArrayList(subAns));
                    j++;k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList(ans);
    }
}