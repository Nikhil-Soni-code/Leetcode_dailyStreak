class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for(int i=left;i<=right;i++){
            int num = i;
            boolean flag = true;
            while(num!=0){
                int d = num%10;
                if(d==0 || i%d!=0){flag = false;break;}
                num/=10;
            }
            if(flag)ans.add(i);
        }return ans;
    }
}