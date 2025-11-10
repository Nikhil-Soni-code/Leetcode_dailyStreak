class Solution {
    public int compress(char[] chars) {
        List<Character> ans = new ArrayList();
        ans.add(chars[0]);
        int count = 1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }else{
                if(count>1){
                    if(count<=9){
                        ans.add((""+count).charAt(0));
                    }else{
                        StringBuilder sbr = new StringBuilder(""+count);
                        for(int j=0;j<sbr.length();j++){
                            ans.add(sbr.charAt(j));
                        }
                    }
                }
                ans.add(chars[i]);
                count=1;
            }
        }
                        if(count>1){
                    if(count<=9){
                        ans.add((""+count).charAt(0));
                    }else{
                        StringBuilder sbr = new StringBuilder(""+count);
                        for(int j=0;j<sbr.length();j++){
                            ans.add(sbr.charAt(j));
                        }
                    }
                }
                for(int i=0;i<ans.size();i++){
                    chars[i] = ans.get(i);
                }
        System.out.print(ans);
        return ans.size();
    }
}