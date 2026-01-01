class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList();
        int start = digits[digits.length-1] + 1;
        ans.add(start%10);
        int carry = start/10;
        for(int i=digits.length-2;i>=0;i--){
            int sum = digits[i] + carry;
            ans.add(sum%10);
            carry = sum/10;
        }
        if(carry!=0){
            ans.add(1);
        }
        Collections.reverse(ans);
        int[] a = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            a[i] = ans.get(i);
        }return a;
    }
}