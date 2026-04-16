class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] minDist = new int[nums.length];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        HashMap<Integer,int[]> map = new HashMap();
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                int[] a= map.get(nums[i]);
                int min = Math.min(nums.length-i+a[0],i-a[0]);
                if(a[1]!=10000000){
                    min = Math.min(min,i-a[1]);
                }
                minDist[i] = Math.min(minDist[i],min);
                map.get(nums[i])[1] = i;
            }else{
                int[] a = new int[2];
                Arrays.fill(a,10000000);
                a[0] = i;
                map.put(nums[i],a);
            }
        }
        map = new HashMap();
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(map.containsKey(nums[i])){
                int[] a= map.get(nums[i]);
                int min = Math.min(nums.length-a[0]+i , a[0]-i);
                if(a[1]!=10000000){
                    min = Math.min(min,a[1]-i);
                }
                minDist[i] = Math.min(minDist[i],min);
                map.get(nums[i])[1] = i;
            }else{
                int[] a = new int[2];
                Arrays.fill(a,10000000);
                a[0] = i;
                map.put(nums[i],a);
            }
        }
        // HashMap<Integer,Integer> ind = new HashMap();
        for(int i=0 ; i<minDist.length ; i++){
            if(minDist[i]==Integer.MAX_VALUE){
                minDist[i] = -1;
            }
            // ind.put(nums[i],minDist[i]);
            System.out.print(minDist[i]+" ");
        }
        List<Integer> ans = new ArrayList();
        for(int i=0 ; i<queries.length ; i++){
            ans.add(minDist[queries[i]]);
        }
        return ans;
    }
}