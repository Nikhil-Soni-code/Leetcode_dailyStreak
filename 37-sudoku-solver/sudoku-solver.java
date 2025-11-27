class Solution {
    private boolean solve(char[][] board,int i,int j){
        if(i==board.length)return true;
        if(j==board[0].length){
            return solve(board,i+1,0);
        }
        if(board[i][j]!='.'){
            return solve(board,i,j+1);
        }
        for(char num='1';num<='9';num++){
            if(isValid(num,i,j,board)){
                board[i][j] = num;
                if(solve(board,i,j+1))return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
    private boolean isValid(char num,int i,int j,char[][] board){

        for(int idx = 0;idx<9;idx++){
            if(board[i][idx]==num)return false;
            if(board[idx][j]==num)return false;
        }
        i = i-i%3;
        j = j-j%3;
        for(int row = i;row<i+3;row++){
            for(int col = j;col<j+3;col++){
                if(board[row][col]==num)return false;
            }
        }
        return true;


        
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
}