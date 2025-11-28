class Solution {
    public String decodeAtIndex(String s, int K) {
        long size = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                size*=(s.charAt(i)-'0');
            }else{
                size++;
            }
        }
        long k = K;
        for(int i=s.length()-1;i>=0;i--)
        {

            if(size!=0)k = k%size;
            if(k==0 && !Character.isDigit(s.charAt(i)))return ""+s.charAt(i);
            if(Character.isDigit(s.charAt(i)))size = size/(s.charAt(i)-'0');
            else size--;
        }
        return ""+s.charAt(0);
    }
}