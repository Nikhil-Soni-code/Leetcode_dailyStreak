// class Solution {
//     public int smallestRepunitDivByK(int k) {
//         int n = 1;
//         int length = 1;
//         while(length<=k){
//             if(n%k==0)return length;
//             n = n*10+1;
//             n = n%k;
//             length++;
//         }return -1;
//     }
// }
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0)return -1;
        int remainder = 1%k;
        int length = 1;
        while(remainder!=0){
            remainder = (remainder*10+1)%k;
            length++;
        }return length;
    }
}