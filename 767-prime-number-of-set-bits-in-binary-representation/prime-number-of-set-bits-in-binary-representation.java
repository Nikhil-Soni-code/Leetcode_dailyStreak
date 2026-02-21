class Solution {
    private int countSetBits(int n){
        String bin = Integer.toBinaryString(n);
        int i = 0;
        int count = 0;
        while(i<bin.length()){
            if(bin.charAt(i++)=='1')count++;
        }return count;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i=left ; i<=right ; i++){
            int count = countSetBits(i);
            if(count==2 || count==3 || count==5 || count==7 ||count==11 || count==13 ||count==17 || count==19 || count==23 || count==29)ans++;
        }return ans;
    }
}