class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        HashSet<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum>target){
                        l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        List<Integer> subList = new ArrayList();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        subList.add(nums[l]);
                        set.add(new ArrayList(subList));
                        l--;k++;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}