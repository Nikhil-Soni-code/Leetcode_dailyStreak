class Solution {
    public int getLeastFrequentDigit(int n) {
        int[]hash = new int[10];
        while(n!=0){
            hash[n%10]++;
            n = n/10;
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=9;i>=0;i--){
            if(hash[i]!=0 && min>=hash[i]){
                min = Math.min(min,hash[i]);
                ans = i;
            }
        }return ans;
    }
}