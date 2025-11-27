class Solution {
    private void find(List<List<Integer>> ans,List<Integer> subAns,int[] nums,int i){
        if(i==nums.length){
            ans.add(new ArrayList(subAns));
            return;
        }
        for(int j=0;j<=subAns.size();j++){
            subAns.add(j,nums[i]);
            find(ans,subAns,nums,i+1);
            subAns.remove(j);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        find(ans,new ArrayList(),nums,0);
        return ans;

    }
}