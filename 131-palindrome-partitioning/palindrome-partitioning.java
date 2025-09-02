class Solution {
    private void find(List<List<String>> ans,List<String> subAns,String s){
        if(s.length()==0){
            ans.add(new ArrayList(subAns));
            return;}
        for(int idx=0;idx<s.length();idx++){
            if(isPalindrome(s.substring(0,idx+1))){
                subAns.add(s.substring(0,idx+1));
                find(ans,subAns,s.substring(idx+1));
                subAns.remove(subAns.size()-1);
            }
        }
    }
    private boolean isPalindrome(String ans){
        int beg = 0,end = ans.length()-1;
        while(beg<end){
            if(ans.charAt(beg)!=ans.charAt(end))return false;
            beg++;end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        find(ans,new ArrayList(),s);
        return ans;
    }
}