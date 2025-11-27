class Solution {
    private void find(List<List<Integer>> ans,List<Integer> subAns,int i,int n,int k){
        if(subAns.size()==k){
            ans.add(new ArrayList(subAns));
            return;
        }
        for(int num=i;num<=n;num++){
            subAns.add(num);
            find(ans,subAns,num+1,n,k);
            subAns.remove(subAns.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        find(ans,new ArrayList(),1,n,k);
        return ans;

    }
}