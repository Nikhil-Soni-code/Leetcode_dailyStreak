class Solution {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length()+num2.length()];
        int idx = digits.length-1;
        for(int i=num2.length()-1;i>=0;i--){
            int carry = 0;
            int k=idx;
            for(int j=num1.length()-1;j>=0;j--){
                int product = ((num2.charAt(i)-'0')*(num1.charAt(j)-'0'))+carry+digits[k];
                digits[k--]= product%10;
                carry = product/10;
            }
            digits[k] = carry;
            idx--;
        }
        StringBuilder num = new StringBuilder();
        int i=0;
        for(i=0;i<digits.length;i++){
            if(digits[i]!=0)break;
        }
        for(int j=i;j<digits.length;j++){
            num.append(digits[j]);
        }
        if(num.length()==0){
            return "0";
        }
        return num.toString();
    }
}