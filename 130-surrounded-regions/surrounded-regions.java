class Solution {
    private void dfs(int i,int j,char[][]board){
        if(i<0||j<0||i==board.length||j==board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j] = '!';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);

    }
    public void solve(char[][] board) {
        int i1=0;
        int i2=board.length-1;

        int j1=0;
        int j2=0;
        for(j1=0;j1<board[0].length;j1++){
            if(board[i1][j1]=='O'){
                dfs(i1,j1,board);
            }
            if(board[i2][j1]=='O'){
                dfs(i2,j1,board);
            }
        }
        i1=0;
        j1=0;
        j2=board[0].length-1;
        for(i1=0;i1<board.length;i1++){
            if(board[i1][j1]=='O'){
                dfs(i1,j1,board);
            }
            if(board[i1][j2]=='O'){
                dfs(i1,j2,board);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='!'){
                    board[i][j]='O';
                }
            }
        }
        return;

    }
}