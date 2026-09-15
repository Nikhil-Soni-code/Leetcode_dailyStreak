class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,false);
        for(int i=2 ; i<n+1 ; i++){
            if(!prime[i]){
                for(int j=i*2 ; j<n+1 ; j+=i){
                    prime[j] = true;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList();
        HashSet<Integer> set = new HashSet();
        for(int i=2 ; i<n+1 ; i++){
            if(prime[i])continue;
            
            if(i+i==n || set.contains(n-i)){
                List<Integer> subAns = new ArrayList();
                subAns.add(n-i);
                subAns.add(i);
                ans.add(new ArrayList(subAns));
            }
            set.add(i);
        }
        Collections.reverse(ans);
        return ans;
        
    }
}