class Solution {
    public int bitwiseComplement(int num) {
        if(num==0)return 1;
        int ans = 0;
        int i=1;
        while(num!=0){
            if((num&1)==0){
                ans += i;
            } 
            i = i<<1;
            num = num>>1;
        }return ans;
    }
}