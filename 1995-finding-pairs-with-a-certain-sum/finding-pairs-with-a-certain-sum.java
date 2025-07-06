class FindSumPairs {
    HashMap<Integer,Integer> map;
    int[] nums1;
    int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        map.put(oldValue,map.get(oldValue)-1);
        nums2[index]+=val;
        if(map.get(oldValue)==0)map.remove(oldValue);
        map.put(oldValue+val,map.getOrDefault(oldValue+val,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(tot-nums1[i])){
                count+=map.get(tot-nums1[i]);
                }
        }return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */