class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        String[] num = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i] = nums[i]+"";
        }
        Arrays.sort(num,(a,b)->
            (b+a).compareTo(a+b)
        );
        for(int i=0;i<num.length;i++){
            ans.append(num[i]);
        }
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)!='0'){
                return ans.toString();
            }
        }
        return "0";
    }
}