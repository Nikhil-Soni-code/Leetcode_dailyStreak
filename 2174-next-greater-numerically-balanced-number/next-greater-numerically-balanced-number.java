class Solution {
    int ans = -1;
    private boolean find(int n,int reqLength,int result,int[] hash){
        if(reqLength==0){
            if(result<=n)return false;
            for(int i=1;i<=9;i++){
                if(hash[i]!=0&&hash[i]!=i)return false;
            }
            ans = result;
            return true;
        }
        for(int i=1;i<=9;i++){
            if(hash[i]!=0){
                hash[i]--;
                if(find(n,reqLength-1,result*10+i,hash))return true;
                hash[i]++;
            }
        }
        return false;
    }
    public int nextBeautifulNumber(int n) {
        if(n==0)return 1;
        int[] hash = new int[10];
        hash[1] = 1;
        hash[2] = 2;
        hash[3] = 3;
        hash[4] = 4;
        hash[5] = 5;
        hash[6] = 6;
        hash[7] = 7;
        hash[8] = 8;
        hash[9] = 9;
        find(n,(int)Math.log10(n) + 1,0,hash);
        if(ans==-1) find(n,(int)Math.log10(n)+2,0,hash);
        return ans;
    }
}

//O(Nlogk)
// class Solution {
//     private boolean balanced(int n){
//         int[] hash  = new int[10];
//         while(n!=0){
//             hash[n%10]++;
//             n/=10;
//         }
//         for(int i=0;i<10;i++){
//             if(hash[i]!=0&&hash[i]!=i)return false;
//         }
//         return true;
//     }
//     public int nextBeautifulNumber(int n) {
//         for(int i=n+1;i<=1224444;i++){
//             if(balanced(i))return i;
//         }
//         return -1;
//     }
// }