class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[]ans = new int[nums.length-map.size()];
        int j=0;
        for(Integer i:map.keySet()){
            if(map.get(i)>1){
                ans[j]=i;
                j++;
            }
        }
        return ans;
    }
}