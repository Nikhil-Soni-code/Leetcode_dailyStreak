class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for(int i=0 ; i<arr.length ; i++)nums[i] = arr[i];
        Arrays.sort(nums,(a,b)->{
            int b1 = Integer.bitCount(a);
            int b2 = Integer.bitCount(b);
            if(b1 == b2)return a-b;
            return b1-b2;
        });
        for(int i=0 ; i<arr.length ; i++)arr[i] = nums[i];

return arr;
    }
}