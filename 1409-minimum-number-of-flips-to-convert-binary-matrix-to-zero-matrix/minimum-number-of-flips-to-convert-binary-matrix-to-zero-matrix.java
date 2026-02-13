class Solution {
    private boolean isBalanced(int[][] mat){
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if(mat[i][j] == 1)return false;
            }
        }
        return true;
    }
    private int flip(int[][] mat,int i,int j){
        if(isBalanced(mat))return 0;
        if(i==mat.length)return 100000;
        if(j==mat[0].length)return flip(mat,i+1,0);
        //flip
        mat[i][j] ^= 1;
        if(i-1 >= 0)mat[i-1][j] ^= 1;
        if(i+1 <= mat.length-1) mat[i+1][j] ^= 1;
        if(j-1 >= 0)mat[i][j-1] ^= 1;
        if(j+1 <= mat[0].length-1)mat[i][j+1] ^= 1;
        int whenFlipped = 1 + flip(mat,i,j+1);

        //undo
        mat[i][j] ^= 1;

        if(i-1 >= 0)mat[i-1][j] ^= 1;
        if(i+1 <= mat.length-1) mat[i+1][j] ^= 1;
        if(j-1 >= 0)mat[i][j-1] ^= 1;
        if(j+1 <= mat[0].length-1)mat[i][j+1] ^= 1;
        int whenNotFlipped = flip(mat,i,j+1);
        return Math.min(whenFlipped,whenNotFlipped);

        
    }
    public int minFlips(int[][] mat) {
        int ans = flip(mat,0,0);
        return ans == 100000? -1:ans;
    }
}