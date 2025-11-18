class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1)return bits[bits.length-1]==0;
        if(bits[bits.length-1]!=0)return false;
        int i=0;
        while(i<bits.length-1){
            if(bits[i]==1){
                i+=2;
            }else{
                i++;
            }
            if(i==bits.length-1)return true;
        }
        return false;
    }
}