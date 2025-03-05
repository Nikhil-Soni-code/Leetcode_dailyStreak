class Solution {
    public long coloredCells(int n) {
        long n1=n;
        long ans = (n1*n1)+(n1-1)*(n1-1);
        return ans;
    }
}