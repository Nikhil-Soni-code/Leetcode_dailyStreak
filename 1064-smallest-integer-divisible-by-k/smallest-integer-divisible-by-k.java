class Solution {
    public int smallestRepunitDivByK(int k) {
        int n = 1;
        int length = 1;
        while(length<=k){
            if(n%k==0)return length;
            n = n*10+1;
            n = n%k;
            length++;
        }return -1;
    }
}