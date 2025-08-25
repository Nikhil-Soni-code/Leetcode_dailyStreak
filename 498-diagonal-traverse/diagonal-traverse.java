class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> list = new ArrayList();
        int m = mat.length,n=mat[0].length;
        for(int i=0;i<=(m-1)+(n-1);i++){
            list.add(new ArrayList());
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int sum = i+j;
                list.get(sum).add(mat[i][j]);
            }
        }
        int[] ans = new int[m*n];
        int idx = 0;
        for(int i=0;i<list.size();i++){
            if(i%2==0){
                List<Integer> subList = list.get(i);
                for(int j=subList.size()-1;j>=0;j--){
                    ans[idx++] = subList.get(j);
                }
            }else{
                List<Integer> subList = list.get(i);
                for(int j=0;j<subList.size();j++){
                    ans[idx++] = subList.get(j);
                }
            }
        }return ans;
    }
}