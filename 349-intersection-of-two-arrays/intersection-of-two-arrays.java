class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List list = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(!list.contains(nums1[i])){
                    list.add(nums1[i]);
                }
                
                i++;j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int []a=new int[list.size()];
        for(i=0;i<list.size();i++){
            a[i]=(int)list.get(i);
        }
        return a;
    }
}