class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList();
            temp.add(1);
            for(int j=1;j<prev.size();j++){
                int a = prev.get(j)+prev.get(j-1);
                
                temp.add(a);
            }
            if(i!=0){
                temp.add(1);
            }
            prev = temp;
        }
        return prev;
    }
}