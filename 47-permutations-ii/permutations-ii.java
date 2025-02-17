class Solution {
    private void permute(int[]nums,int idx,HashSet<List<Integer>> set,List<Integer> list){
        if(idx>=nums.length){
            set.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<=list.size();i++){
            list.add(i,nums[idx]);
            permute(nums,idx+1,set,list);
            list.remove(i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet();
        permute(nums,0,set,new ArrayList());
        return new ArrayList(set);
    }
}