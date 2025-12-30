class Solution {
    private boolean check(int idx,int jdx,int[][] grid){
        HashSet<Integer> set = new HashSet();
        int prevSum = -1;
        for(int i=idx ; i<idx+3 ; i++){
            int sum = 0;
            for(int j=jdx ; j<jdx+3 ; j++){
                if(set.contains(grid[i][j]) || grid[i][j] > 9 || grid[i][j] ==0)return false;
                sum+=grid[i][j];
                set.add(grid[i][j]);
            }
            if(prevSum != -1 && prevSum != sum)return false;
            prevSum = sum;
        }

        for(int j=jdx ; j<jdx+3 ; j++){
            int sum = 0;
            for(int i=idx ; i<idx+3 ; i++){
                sum+=grid[i][j];
            }
            if(prevSum != sum)return false;
        }
        int i = idx;
        int j = jdx;
        int sum = 0;
        while(i<idx+3 && j<jdx+3){
            sum += grid[i][j];
            i++;j++;
        }
        if(sum != prevSum)return false;
        i = idx;
        j = jdx+2;
        sum = 0;
        while(i<idx+3 && j>=jdx){
            sum += grid[i][j];
            i++;j--;
        }
        if(sum != prevSum)return false;
        return true;

        

    }
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(check(i,j,grid))count++;
            }
        }return count;
    }
}