class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beg = 0,end = (matrix.length*matrix[0].length)-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]==target){
                return true;
            }
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]>target){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return false;
    }
}