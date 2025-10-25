class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0)return -1;
        int num = 1,count=1;
        if(k==1)return 1;
        for(int i=0;i<=k;i++){
            if(num==0)return count;
            num = (num*10+1)%k;

            count++;
        }
        return -1;
    }
}