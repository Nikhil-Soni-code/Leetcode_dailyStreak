class Solution {
    private String create(StringBuilder sbr,HashSet<String> set,int n){
        if(sbr.length()==n){
            if(!set.contains(sbr.toString())){
                return sbr.toString();
            }
            return "";
        }
        sbr.append('0');
        String resp = create(sbr,set,n);
        if(resp!=""){
            return resp;
        }
        sbr.deleteCharAt(sbr.length()-1);
        sbr.append('1');
        resp = create(sbr,set,n);
        if(resp!=""){
            return resp;
        }
        sbr.deleteCharAt(sbr.length()-1);
        return "";

    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        return create(new StringBuilder(),set,n);
    }
}