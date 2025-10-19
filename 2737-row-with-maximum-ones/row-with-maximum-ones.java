class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int i = 0;
        Arrays.fill(ans,-1);
        for(int[] row :mat){
            int count = 0;
            for(int j=0;j<row.length;j++){
                if(row[j]==1)count++;
            }
            row[0] = count;
            if(ans[1]<count){
                ans[1] = count;
                ans[0] = i;
            }
            i++;
        }
        return ans;
        
    }
}