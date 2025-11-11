class Solution {
    private void combo(List<List<Integer>> ans,List<Integer> subAns,int[] candidates,int i,int target){
        if(target==0){
            ans.add(new ArrayList(subAns));
            return;
        }
        if(i==candidates.length){
            return;
        }
        if(target>=candidates[i]){
            subAns.add(candidates[i]);
            combo(ans,subAns,candidates,i,target-candidates[i]);
            subAns.remove(subAns.size()-1);
        }
        combo(ans,subAns,candidates,i+1,target);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        combo(ans,new ArrayList(),candidates,0,target);
        return ans;
    }
}