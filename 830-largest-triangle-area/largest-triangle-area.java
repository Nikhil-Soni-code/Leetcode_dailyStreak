class Solution {
    private double findArea(int x1,int x2,int x3,int y1,int y2,int y3){
        double area = Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return area/2;

    }
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for(int i=0;i<points.length-2;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<points.length-1;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                for(int k=j+1;k<points.length;k++){
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    area  = Math.max(area,findArea(x1,x2,x3,y1,y2,y3));
                }
            }
        }
        return area;
        

    }
}