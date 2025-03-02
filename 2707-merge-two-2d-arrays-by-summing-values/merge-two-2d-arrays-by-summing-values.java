class Pair{
    int id;
    int val;
    public Pair(int id,int val){
        this.id = id;
        this.val = val;
    }
}
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i=0;
        int j=0;
        List<Pair> list = new ArrayList();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                Pair pair = new Pair(nums1[i][0],nums1[i][1]+nums2[j][1]);
                list.add(pair);
                i++;j++;
            }
            else if(nums1[i][0]<nums2[j][0]){
                Pair pair = new Pair(nums1[i][0],nums1[i][1]);
                list.add(pair);
                i++;
            }
            else{
                Pair pair = new Pair(nums2[j][0],nums2[j][1]);
                list.add(pair);
                j++;
            }
        }
        while(i<nums1.length){
            Pair pair = new Pair(nums1[i][0],nums1[i][1]);
                list.add(pair);
                i++;
        }
        while(j<nums2.length){
            Pair pair = new Pair(nums2[j][0],nums2[j][1]);
                list.add(pair);
                j++;
        }
        int[][]ans = new int[list.size()][2];
        for(i=0;i<list.size();i++){
            ans[i][0] = list.get(i).id;
            ans[i][1] = list.get(i).val;
        }
        return ans;

    }
}