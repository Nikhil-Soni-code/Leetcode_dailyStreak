class Pair{
    int idx;
    String str;
    String iden;
    public Pair(int idx,String str,String iden){
        this.idx = idx;
        this.str = str;
        this.iden = iden;
    }
}
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            int cmp = a.str.compareTo(b.str);
            if(cmp==0){
                return a.iden.compareTo(b.iden);
            }return cmp;

        });
        for(int i=0;i<logs.length;i++){
            int j =0 ;
            if(!Character.isDigit(logs[i].charAt(logs[i].length()-1))){
                StringBuilder sbr = new StringBuilder();
                while(j<logs[i].length()&&logs[i].charAt(j)!=' '){
                    sbr.append(logs[i].charAt(j));
                    j++;
                }
                String str = logs[i].substring(j);
                Pair pair = new Pair(i,str,sbr.toString());
                logs[i] = "";
                pq.add(pair);
            }

        }
        String[] ans = new String[logs.length];
        int idx = 0;
        while(pq.size()!=0){
            Pair pair = pq.poll();
            ans[idx++] = pair.iden+pair.str;
        }
        for(int i=0;i<logs.length;i++){
            if(!logs[i].equals("")){
                ans[idx++] = logs[i];
            }
        }
        return ans;

    }
}