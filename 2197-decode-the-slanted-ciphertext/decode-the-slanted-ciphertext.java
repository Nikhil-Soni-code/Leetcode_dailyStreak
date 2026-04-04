class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length()/rows;
        char[][] mat = new char[rows][encodedText.length()/rows];
        for(char ch[] : mat){
            Arrays.fill(ch,' ');
        }
        if(encodedText.length()==0)return "";
        int i=0, j=0;
        for(int idx=0 ; idx<encodedText.length() ; idx++){
            char ch = encodedText.charAt(idx);
            mat[i][j] = ch;
            j = (j+1);
            if(j==cols){
                j=0;
                i++;
            }
        }
        j=0;
        i=0;
        StringBuilder ans = new StringBuilder();
        for(int colstart = 0 ; colstart < cols ; colstart++){
            i=0 ; j=colstart;
            while(i<rows && j<cols){
                ans.append(mat[i][j]);
                i++;j++;
            }
        }
        
        i=ans.length()-1;
        
        while(!Character.isLetter(ans.charAt(i))){
            i--;
        }

        return ans.toString().substring(0,i+1);
    }
}