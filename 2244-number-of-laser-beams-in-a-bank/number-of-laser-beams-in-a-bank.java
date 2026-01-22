class Solution {
    public int numberOfBeams(String[] bank) {
        int prevDevice = 0;
        for(int i=0;i<bank[0].length();i++){
            if(bank[0].charAt(i)=='1')prevDevice++;
        }
        System.out.print(prevDevice);
        int ans = 0;
        for(int j=1;j<bank.length;j++){
            String device = bank[j];
            int currDevice = 0;
            for(int i=0;i<device.length();i++){
                if(device.charAt(i)=='1'){
                    currDevice++;
                }
            }
        System.out.print(currDevice);
            ans += (prevDevice*currDevice);
            if(currDevice!=0)prevDevice = currDevice;

        }
        return ans;
    }
}