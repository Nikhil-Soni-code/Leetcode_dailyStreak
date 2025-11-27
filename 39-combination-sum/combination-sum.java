class Solution {
    private void find(List<List<Integer>> ans,List<Integer> subAns,int[] candidates,int target,int i){
        
        if(target==0){
            ans.add(new ArrayList(subAns));
            return;
        }
        if(i==candidates.length)return;
        if(target>=candidates[i]){
            subAns.add(candidates[i]);
            find(ans,subAns,candidates,target-candidates[i],i);
            subAns.remove(subAns.size()-1);
        }
        find(ans,subAns,candidates,target,i+1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        find(ans,new ArrayList(),candidates,target,0);
        return ans;

    }
}