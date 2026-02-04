class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for(int num:left){
            max = Math.max(max,num);
        }
        for(int num:right){
            max = Math.max(max,n-num);
        }return max;
    }
}