class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonal = 0;
        for(int i=0;i<dimensions.length;i++){
            int diagonal = dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1];
            if(diagonal>maxDiagonal){
                maxArea = dimensions[i][0]*dimensions[i][1];
                maxDiagonal = diagonal;
            }
            else if(diagonal==maxDiagonal){
                maxArea = Math.max(maxArea,dimensions[i][0]*dimensions[i][1]);
            }
        }return maxArea;
    }
}