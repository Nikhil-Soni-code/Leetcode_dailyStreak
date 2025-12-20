class Solution {
    public int smallestRepunitDivByK(int k) {
        int count = 1;
        int number = 1%k;
        while(count<=k){
            if(number==0)return count;
            count++;
            number = (number*10+1)%k;
        }
        return -1;
    }
}