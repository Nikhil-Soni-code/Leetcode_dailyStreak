class Solution {
    private void ff(int[][] image,int i,int j,int color,int target){
        if(i==image.length||j==image[0].length||i<0||j<0||image[i][j]!=target){
            return;
        }
        image[i][j] = color;
        ff(image,i-1,j,color,target);
        ff(image,i+1,j,color,target);
        ff(image,i,j-1,color,target);
        ff(image,i,j+1,color,target);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if(target==color)return image;
        ff(image,sr,sc,color,target);
        return image;
    }
}