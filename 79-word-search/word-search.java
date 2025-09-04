class Solution {
    private boolean check(char[][] board,String word,int i,int row,int col){
        if(i==word.length())return true;
        if(row<0||col<0||row==board.length||col==board[0].length||board[row][col]=='*')return false;
        if(word.charAt(i)!=board[row][col])return false;
        board[row][col] = '*';
        boolean result = check(board,word,i+1,row+1,col)||check(board,word,i+1,row-1,col)||check(board,word,i+1,row,col+1)||check(board,word,i+1,row,col-1);
        board[row][col] = word.charAt(i);

        return result;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(check(board,word,0,i,j))return true;
                }
            }
        }return false;
    }
}