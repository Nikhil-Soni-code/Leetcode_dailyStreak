class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0 ; i<changed.length ; i++){
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }
        int[] ans = new int[changed.length/2];
        int idx = 0;
        for(int i=0 ; i<changed.length ; i++){
            if(map.containsKey(changed[i])){
                if(changed[i]==0){
                    if(map.get(changed[i])<=1){
                        return new int[]{};
                    }
                    ans[idx++] = changed[i];
                    map.put(changed[i],map.get(changed[i])-2);
                    if(map.get(changed[i])==0)map.remove(changed[i]);
                }
                else if(map.containsKey(changed[i]*2)){
                    ans[idx++] = changed[i];
                    map.put(changed[i],map.get(changed[i])-1);
                    map.put(changed[i]*2,map.get(changed[i]*2)-1);
                    if(map.get(changed[i])==0)map.remove(changed[i]);
                    if(map.get(changed[i]*2)==0)map.remove(changed[i]*2);
                }else{
                    return new int[]{};
                }
            }
        }return ans;
        
    }
}