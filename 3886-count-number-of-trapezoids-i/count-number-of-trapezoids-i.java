class Solution {
    public int countTrapezoids(int[][] points) {
        int MOD = 1000000007;
        HashMap<Integer,Integer> map = new HashMap();
        for(int[] point:points){
            map.put(point[1],map.getOrDefault(point[1],0)+1);
        }
        List<Long> list = new ArrayList();
        long prefix = 0;
        for(Integer n:map.values()){
                long combinationToSelectTwo = ((long)n*(n-1)%MOD)/2;
                list.add(combinationToSelectTwo);
                prefix = (prefix+combinationToSelectTwo)%MOD;

        }
        int result = 0;
        for(Long n:list){
            prefix -= n;
            result = (int)(result + (n * prefix) % MOD) % MOD;
        }
        return result;
        
    }
}