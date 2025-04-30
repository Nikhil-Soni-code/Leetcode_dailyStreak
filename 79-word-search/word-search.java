class Solution {
    private boolean search(char[][] board,String word,int idx,int i,int j){
        if(idx==word.length()){
            return true;
        }
        if(i>=board.length||j>=board[0].length||i<0||j<0||board[i][j]=='*'||board[i][j]!=word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        if(search(board,word,idx+1,i-1,j))return true;
        if(search(board,word,idx+1,i,j-1))return true;
        if(search(board,word,idx+1,i+1,j))return true;
        if(search(board,word,idx+1,i,j+1))return true;
        board[i][j] = temp;
        return false;
        


    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}