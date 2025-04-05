class Solution {
    public void subSet(List<List> list,List subset,int []nums,int i){
        if(i==nums.length){
            list.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[i]);
        subSet(list,subset,nums,i+1);
        subset.remove(subset.size()-1);
        subSet(list,subset,nums,i+1);

    }
    public int subsetXORSum(int[] nums) {
        List<List> list = new ArrayList();
        subSet(list,new ArrayList(),nums,0);
        

        int sum=0;
        for(List l : list){
            int xor=0;
            for(int j=0;j<l.size();j++){
                xor=xor^(int)l.get(j);
                System.out.println(xor);
            }
            sum=sum+xor;
        }
        return sum;
    }
    
}