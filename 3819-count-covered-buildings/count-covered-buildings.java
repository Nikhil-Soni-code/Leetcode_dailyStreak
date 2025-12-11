class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,TreeSet<Integer>> col = new HashMap();
        HashMap<Integer,TreeSet<Integer>> row = new HashMap();

        for(int[] building : buildings){
            int r = building[0];
            int c = building[1];
            if(col.containsKey(c)){
                col.get(c).add(r);
            }
            else{
                TreeSet<Integer> list = new TreeSet();
                list.add(r);
                col.put(c,list);
            }
            if(row.containsKey(r)){
                row.get(r).add(c);
            }
            else{
                TreeSet<Integer> list = new TreeSet();
                list.add(c);
                row.put(r,list);
            }
        }
        int count = 0;
        for(int[] building : buildings){
            int r = building[0];
            int c = building[1];
            boolean small = false,large = false;

            if(row.containsKey(r)){
                small = false;large = false;
                if(row.get(r).lower(c)!=null)small = true;
                if(row.get(r).higher(c)!=null)large = true;

            }
            if(small && large){
                small = false;large = false;
                if(col.get(c).lower(r)!=null)small = true;
                if(col.get(c).higher(r)!=null)large = true;
                if(small && large){
                    count++;
                }
            }
        }
        return count;
        
    }
}