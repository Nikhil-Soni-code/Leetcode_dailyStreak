class Solution {
    private int[] left_Smaller(int[] prefix){
        int []a=new int[prefix.length];
        Stack<Integer> stack=new Stack();
        stack.push(-1);
        for(int i=0;i<prefix.length;i++){
            while(stack.peek()!=-1 && prefix[stack.peek()]>=prefix[i]){
                stack.pop();
            }
            a[i]=stack.peek();
            stack.push(i);
        }
        return a;
    }
        private int[] right_Smaller(int[] prefix){
        int []a=new int[prefix.length];
        Stack<Integer> stack=new Stack();
        stack.push(prefix.length);
        for(int i=prefix.length-1;i>=0;i--){
            while(stack.peek()!=prefix.length && prefix[stack.peek()]>=prefix[i]){
                stack.pop();
            }
            a[i]=stack.peek();
            stack.push(i);
        }
        return a;

    }
    private int maxHistogram(int[] prefix){
        int[]left_min=left_Smaller(prefix);
        int[]right_min=right_Smaller(prefix);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<prefix.length;i++){
            int area=(right_min[i]-left_min[i]-1)*prefix[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int[][]prefix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            int prefixSum=0;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]=='0'){
                    prefixSum=0;
                }
                else{
                    prefixSum++;
                }
                prefix[j][i]=prefixSum;
            }
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<prefix.length;i++){
            maxArea=Math.max(maxArea,maxHistogram(prefix[i]));
        }
        return maxArea;

    }
}