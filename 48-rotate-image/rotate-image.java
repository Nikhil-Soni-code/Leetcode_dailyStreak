class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix[0].length;i++){
            int beg = 0,end = matrix.length-1;
            while(beg<end){
                int temp = matrix[beg][i];
                matrix[beg][i] = matrix[end][i];
                matrix[end][i] = temp;
                beg++;end--;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}