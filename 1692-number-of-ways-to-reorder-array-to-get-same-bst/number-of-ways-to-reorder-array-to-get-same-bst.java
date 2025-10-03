class Solution {
    int MOD = 1000000007;
    List<List<Long>> triangle = new ArrayList();
    private void pascalTriangle(int n){
        triangle.add(new ArrayList());
        triangle.get(0).add(1L);
        for(int i=1;i<=n;i++){
            triangle.add(new ArrayList());
            triangle.get(i).add(1L);
            for(int j=1;j<triangle.get(i-1).size();j++){
                long value = (triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j))%MOD;
                triangle.get(i).add(value);
            }
            triangle.get(i).add(1L);
        }
    }
    private long findCombi(int n,int r){
        return triangle.get(n).get(r);
    }
    private long findNumOfWays(List<Integer> nums){
        if(nums.size()<=2){
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<root){
                left.add(nums.get(i));
            }else{
                right.add(nums.get(i));
            }
        }
        long leftPart = findNumOfWays(left);
        long rightPart = findNumOfWays(right);

        long ways = findCombi(nums.size()-1, left.size());
        ways = (ways * leftPart) % MOD;
        ways = (ways * rightPart) % MOD;
        return ways;



    }
    public int numOfWays(int[] nums) {
        List<Integer> num = new ArrayList();
        for(int i:nums){
            num.add(i);
        }
        pascalTriangle(nums.length);
        return (int)(findNumOfWays(num)-1);
    }
}