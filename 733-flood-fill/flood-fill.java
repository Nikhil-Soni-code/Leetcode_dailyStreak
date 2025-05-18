class Solution {
    private void dfs(int i,int j,int color,int[][]image,int[][]ans,int prevColor){
        if(i<0||i>=image.length||j<0||j>=image[0].length)return;
        if(i-1>=0&&image[i-1][j]==prevColor&&ans[i-1][j]==prevColor){
            ans[i-1][j] = color;
            dfs(i-1,j,color,image,ans,prevColor);
        }
        if(j-1>=0&&image[i][j-1]==prevColor&&ans[i][j-1]==prevColor){
            ans[i][j-1] = color;
            dfs(i,j-1,color,image,ans,prevColor);
        }
        if(i+1<image.length&&image[i+1][j]==prevColor&&ans[i+1][j]==prevColor){
            ans[i+1][j] = color;
            dfs(i+1,j,color,image,ans,prevColor);
        }
        if(j+1<image[0].length&&image[i][j+1]==prevColor&&ans[i][j+1]==prevColor){
            ans[i][j+1] = color;
            dfs(i,j+1,color,image,ans,prevColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                ans[i][j] = image[i][j];
            }
        }
        if (image[sr][sc] != color) {
            ans[sr][sc] = color;  // fix: paint starting point
            dfs(sr, sc, color, image, ans, image[sr][sc]);
        }
        return ans;
    }
}