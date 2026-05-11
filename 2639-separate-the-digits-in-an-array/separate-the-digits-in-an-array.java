class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i=0 ; i<nums.length ; i++){
            String num = ""+nums[i];
            for(char ch : num.toCharArray()){
                list.add(ch-'0');
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            ans[i] = list.get(i);
        }return ans;
    }
}