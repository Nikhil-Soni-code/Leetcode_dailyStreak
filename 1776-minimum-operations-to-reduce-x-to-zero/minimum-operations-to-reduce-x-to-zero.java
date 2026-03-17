class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> prefix = new HashMap();
        int sum = 0;
        int ans = 1000000000;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            if(sum==x){
                ans = Math.min(ans,i+1);
            }
            if(!prefix.containsKey(sum))prefix.put(sum,i+1);
        }
        sum = 0;
        for(int i=nums.length-1 ; i>=0 ; i--){
            sum += nums[i];
            if(sum==x){
                ans = Math.min(nums.length-i,ans);
            }
            else if(prefix.containsKey(x-sum) && prefix.get(x-sum) != i+1){
                int opr = prefix.get(x-sum) + nums.length - i;
                ans = Math.min(ans,opr);
            }
        }
        if(ans==1000000000)return -1;
        return ans;

    }
}