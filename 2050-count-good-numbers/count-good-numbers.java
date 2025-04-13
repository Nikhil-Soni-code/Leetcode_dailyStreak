class Solution {
    int mod  = 1000000007;
    private long power(long base,long exp){
        long result = 1;
        while(exp>0){
            if((exp&1)==1){
                result = (result*base)%mod;
            }
            base = (base*base)%mod;
            exp >>=1;
        }
        return (result % mod);
    }
    public int countGoodNumbers(long n) {
        long ans = 1;
        if((n&1)==1){//oddnumber
            ans = (power(5,n/2+1)*power(4,n/2))%mod;
        }else{
            ans = (power(5,n/2)*power(4,n/2))%mod;
        }return (int)ans;
    }
}
// class Solution {
//     private long goody(long ans,long x,long n){
//         if(n==0){
//             return ans;
//         }
//         if((n&1)==1){
//             ans=(ans*x)%1000000007;
//         }
//         return goody(ans,(x*x)%1000000007,n>>1);
//     }
//     public int countGoodNumbers(long n) {
//         long ans=1;
//         if((n&1)==1){
//             ans=5;
//         }
//         long x=20;
//         return (int)goody(ans,x,n/2);
//     }
// }
// // class Solution {
// //     public int countGoodNumbers(long n1) {
// //         long ans=1;
// //         if((n1&1)==1){
// //             ans=5;
// //         }
// //         long x=20;
// //         long n=n1/2;
// //         while(n!=0){
// //             if((n&1)==1){
// //                 ans=(ans*x)%1000000007;
// //             }
// //             x=(x*x)%1000000007;
// //             n=n>>1;
// //         }
// //         return (int)ans;
// //     }
// // }