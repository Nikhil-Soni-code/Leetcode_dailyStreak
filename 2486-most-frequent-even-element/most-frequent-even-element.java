class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] hash = new int[100001];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
            hash[nums[i]]++;
        }
        int freq = 0;
        int ele = -1;
        for(int i=0;i<100001;i++){
            if(hash[i]>freq){
                freq = hash[i];
                ele = i;
            }
        }
        return ele;
    }
}