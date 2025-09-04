class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j>=i){
                                   int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                }
 
            }
        }
        for(int i=0;i<matrix.length;i++){
            int c2=matrix[0].length-1,c1=0;
            while(c1<c2){
                int temp = matrix[i][c1];
                matrix[i][c1] = matrix[i][c2];
                matrix[i][c2] = temp;
                c1++;c2--;
            }
        }
    }
}