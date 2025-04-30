class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList();
        if(nums.length==0)return ans;
        int start = 0,end = 1;
        while(end<nums.length){
            if(nums[end-1]+1!=nums[end]){
                if(end-start>1){
                    String interval = nums[start]+"->"+nums[end-1];
                    ans.add(interval);
                }else{
                    String interval = nums[end-1]+"";
                    ans.add(interval);
                }
                start = end;
            }
            end++;
        }
                if(end-start>1){
                    String interval = nums[start]+"->"+nums[end-1];
                    ans.add(interval);
                }else{
                    String interval = nums[end-1]+"";
                    ans.add(interval);
                }
        return ans;

    }
}