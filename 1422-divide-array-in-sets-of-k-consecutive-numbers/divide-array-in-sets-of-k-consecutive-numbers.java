class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int ele = nums[i];
                for(int j=ele;j<ele+k;j++){
                    if(map.containsKey(j)){
                        map.put(j,map.get(j)-1);
                        if(map.get(j)==0){
                            map.remove(j);
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}