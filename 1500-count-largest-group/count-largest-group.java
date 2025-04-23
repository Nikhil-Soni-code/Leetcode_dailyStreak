class Solution {
    private int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=1;i<=n;i++){
            int sum = digitSum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        int maxGroupSize = 0;
        int count = 0;
        for(Integer key:map.keySet()){
            if(map.get(key)>maxGroupSize){
                count = 1;
                maxGroupSize = map.get(key); 
            }
            else if(map.get(key)==maxGroupSize){
                count++;
            }
        }
        return count;
    }
}