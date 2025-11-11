class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            for(int j=i+1;j<nums.length-1;j++){
                int k = j+1;
                int l = nums.length-1;
                long sum = nums[i]+nums[j];



                while(k<l){
                    if(sum+nums[k]+nums[l]==target){
                List<Integer> subAns = new ArrayList();
                        subAns.add(nums[i]);
                        subAns.add(nums[j]);
                        subAns.add(nums[k]);
                        subAns.add(nums[l]);
                        ans.add(new ArrayList(subAns));
                        l--;k++;
                    }
                    else if(sum+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        k++;
                    }
                }

            }
        }
        return new ArrayList(ans);

    }
}