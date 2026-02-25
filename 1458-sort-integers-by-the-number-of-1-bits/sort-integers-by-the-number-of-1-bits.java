class Solution {
    private int countSetBits(int ele){
        int count = 0;
        while(ele!=0){
            if((ele&1)==1)count++;
            ele = ele>>1;
        }return count;
    }
    public int[] sortByBits(int[] nums) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(int i=0 ; i<nums.length ; i++){
            int count = countSetBits(nums[i]);
            if(map.containsKey(count)){
                List<Integer> temp = map.get(count);
                temp.add(nums[i]);
                map.put(count,temp);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(count,temp);
            }
        }
        int i = 0;
        for(Integer key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for(Integer ele : list){
                nums[i++] = ele;
            }
        }return nums;
    }
}