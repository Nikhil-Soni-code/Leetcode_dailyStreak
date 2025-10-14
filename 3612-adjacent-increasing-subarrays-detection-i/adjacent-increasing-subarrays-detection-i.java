class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        for(int i=0;i<=nums.size()-2*k;i++){
            int k2=k;
            int flag1=0;
            int flag2=0;
            
            int j=i;
            while(k2>1){
                if(j<nums.size()-1&&nums.get(j)>=nums.get(j+1)){
                    flag1=1;
                    break;
                }
                j++;
                k2--;
            }
            if(flag1==0){
                j=i+k;
                k2=k;
                while(k2>1){
                    
                    if(j<nums.size()-1&&nums.get(j)>=nums.get(j+1)){
                        flag2=1;
                        break;
                    }
                    
                    j++;
                    k2--;
                }
            }
            k2=k;
            if(flag1==0&&flag2==0){
                return true;
            }
        }
        return false;
    }
}