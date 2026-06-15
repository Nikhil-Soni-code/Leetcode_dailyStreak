class Solution {
    private void find(HashSet<List<Integer>> ans, int[] nums,int i, List<Integer> subAns){
                if(subAns.size()>1){
            ans.add(new ArrayList(subAns));
        }
        if(i>=nums.length)return;

        if(subAns.size()==0 || nums[i]>=subAns.get(subAns.size()-1)){       
            subAns.add(nums[i]);
            find(ans,nums,i+1,subAns);
            subAns.remove(subAns.size()-1);
        }

        find(ans,nums,i+1,subAns);

        
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet();
        find(ans,nums,0,new ArrayList());
        return new ArrayList(ans);
        
    }
}