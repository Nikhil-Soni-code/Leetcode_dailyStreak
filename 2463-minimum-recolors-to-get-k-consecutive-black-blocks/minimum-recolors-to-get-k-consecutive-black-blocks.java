class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOperations = 101;
        for(int i=0;i<blocks.length();i++){
            int whiteCount=0;
            int blackCount=0;
            for(int j=i;j<blocks.length();j++){
                if(blocks.charAt(j)=='W'){
                    whiteCount++;
                }else{
                    blackCount++;
                }
                if(whiteCount+blackCount==k){
                    minOperations = Math.min(minOperations,whiteCount);
                    break;
                }
            }
        }
        return minOperations;
    }
}