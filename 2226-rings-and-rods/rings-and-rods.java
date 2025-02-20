class Solution {
    public int countPoints(String rings) {
        String[] a = new String[10];
        Arrays.fill(a,"");
        for(int i=0;i<rings.length()-1;i+=2){
            int idx = rings.charAt(i+1)-'0';
            a[idx]+=rings.charAt(i);
        }
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i].indexOf('R')!=-1&&a[i].indexOf('G')!=-1&&a[i].indexOf('B')!=-1){
                count++;
            }
        }
        return count;

    }
}