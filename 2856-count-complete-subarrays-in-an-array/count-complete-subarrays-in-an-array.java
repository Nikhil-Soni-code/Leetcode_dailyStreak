class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int size = map.size();
        map = new HashMap();
        int i=0,count = 0;
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>=size){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            count+=j-i+1;
        }
        return (nums.length*(nums.length+1)/2)-count;
    }
}