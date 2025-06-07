class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int number = 0;
        for(int i=1;i<s.length();i++){

            if(romanMap.get(s.charAt(i-1))>=romanMap.get(s.charAt(i))){
                number+=romanMap.get(s.charAt(i-1));
            }else{
                number-=romanMap.get(s.charAt(i-1));
            }
        }
        number+=romanMap.get(s.charAt(s.length()-1));
        return number;

    }
}