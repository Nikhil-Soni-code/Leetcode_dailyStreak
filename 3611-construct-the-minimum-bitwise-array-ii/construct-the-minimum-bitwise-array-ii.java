class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            boolean flag = false;
            if(nums.get(i)%2==0){
                ans[i] = -1;
            }else{
                char[] sbr = (Integer.toBinaryString(nums.get(i))).toCharArray();
                for(int j=sbr.length-1;j>=0;j--){
                    if(sbr[j]=='0'){
                        flag = true;
                        sbr[j+1] = '0';
                        break;
                    }
                }
                if(!flag)sbr[0] = '0';
                int num = 0;
                int pow = 1;
                for(int j=sbr.length-1;j>=0;j--){
                    num = num+(sbr[j]-'0')*pow;
                    pow = pow*2;
                }
                ans[i] = num;
            }


        }
        return ans;
    }
}