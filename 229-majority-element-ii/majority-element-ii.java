class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int majority1 = Integer.MIN_VALUE;
        int majority2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(count1==0&&nums[i]!=majority2){
                majority1 = nums[i];
            }if(count2==0&&nums[i]!=majority1){
                majority2 = nums[i];
            }
            if(nums[i]==majority1){
                count1++;
            }else if(nums[i]==majority2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==majority1){
                count1++;
            }
            if(nums[i]==majority2){
                count2++;
            }
        }
        List<Integer> ans = new ArrayList();
        if(count1>nums.length/3){
            ans.add(majority1);
        }
        if(count2>nums.length/3){
            ans.add(majority2);
        }
        return ans;

    }
}