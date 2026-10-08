class Solution {
    private boolean search(char[][] board,String word, int idx,int i, int j){
        if(idx>=word.length())return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length||board[i][j]=='.' || board[i][j]!=word.charAt(idx))return false;
        char ch = board[i][j];
        board[i][j] = '.';
        boolean res = search(board,word,idx+1,i-1,j)||search(board,word,idx+1,i+1,j)||search(board,word,idx+1,i,j+1)||search(board,word,idx+1,i,j-1);
        board[i][j] = ch;
        return res;

    }
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,word,0,i,j))return true;
                }
            }
        }return false;

    }
}