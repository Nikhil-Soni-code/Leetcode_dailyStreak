class Solution {
    public void setZeroes(int[][] matrix) {
        int row = -1;
        int col = -1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0||j==0){
                        if(i==0&&j==0){
                            row=0;
                            col=0;
                        }
                        else if(i==0){
                            row=0;
                        }else{
                            col=0;
                        }
                    }
                    else{
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }

                }
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if(col==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}