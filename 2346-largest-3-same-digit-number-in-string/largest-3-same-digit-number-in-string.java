class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        int maxNum = -1;
        for(int i=1;i<num.length()-1;i++){
            if(num.charAt(i)==num.charAt(i-1)&&num.charAt(i)==num.charAt(i+1)&&maxNum<num.charAt(i)-'0'){
                max = ""+num.charAt(i)+num.charAt(i)+num.charAt(i);
                maxNum = num.charAt(i)-'0';
            }
        }
        return max;
    }
}