class Solution {
    private int dfs(List<Integer> perm,int n,int sum){
        if(sum==n*(n+1)/2){
            return 1;
        }
        int count =  0;
        int idx = perm.size()+1;
        for(int i=1;i<=n;i++){
            if(!perm.contains(i)&&(i%idx==0||idx%i==0)){
                perm.add(i);
                count+=dfs(perm,n,sum+i);
                perm.remove(perm.size()-1);
            }
        }
        return count;
    }
    public int countArrangement(int n) {
        List<Integer> perm = new ArrayList();
        return dfs(perm,n,0);
    }
}