class Solution {
    public int findGCD(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
            }
            if(min>nums[i]){
                min = nums[i];
            }
        }
        int a=max;
        int b=min;
        while(a!=0&&b!=0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        if(a==0){
            return b;
        }
        return a;
    }
}