class Solution {
    private void generate(int[] nums,List<Integer> subAns,List<List<Integer>> ans,int i){
        if(i==nums.length){
            ans.add(new ArrayList(subAns));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!subAns.contains(nums[j])){
                subAns.add(nums[j]);
                generate(nums,subAns,ans,i+1);
                subAns.remove(subAns.size()-1);
            }
        }


    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        generate(nums,new ArrayList(),ans,0);
        return ans;
    }
}