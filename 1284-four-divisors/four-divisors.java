class Solution {
    private int findDivisors(int num){
        int count = 0;
        int sum = 0;
        for(int i=1;i<=Math.pow(num,0.5);i++){
            if(num%i==0){
                sum += i;
                count++;
                if(num/i != i){
                    sum += num/i;
                    count++;
                }
            }
        }
        System.out.println(sum);
        return (count==4)?sum:0;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += findDivisors(nums[i]);
        }
        return sum;
    }
}