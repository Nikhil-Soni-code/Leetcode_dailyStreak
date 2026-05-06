class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] ans = new char[boxGrid[0].length][boxGrid.length];
        for(int i=0 ; i<boxGrid.length ; i++){
            for(int j=0 ; j<boxGrid[0].length ; j++){
                ans[j][boxGrid.length-1-i] = boxGrid[i][j];
            }
        }
        for(int j=0 ; j<ans[0].length ; j++){
            int i=ans.length-1;
            int count = 0;
            int prev = ans.length-1;
            while(i>=0){
                if(ans[i][j]=='#'){
                    count++;
                    ans[i][j] = '.';
                }
                else if(ans[i][j]=='*'){

                    int k=prev;
                    while(count!=0){
                        ans[k][j]='#';
                        k--;
                        count--;
                    }
                    prev = i-1;
                }
                i--;
            }
            
                    int k=prev;
                    while(count!=0){
                        ans[k][j]='#';
                        k--;
                        count--;
                    }

        }
        return ans;
    }
}