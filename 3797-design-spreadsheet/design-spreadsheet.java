class Spreadsheet {
    HashMap<String,Integer> map;
    public Spreadsheet(int rows) {
        map = new HashMap();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] str = formula.split("\\+");

        String num1 = str[0];
        String num2 = str[1];
        int ans = 0;
        if(num1.charAt(0)>='A'&&num1.charAt(0)<='Z'){
            ans+=map.getOrDefault(num1,0);
        }else{
            ans+=Integer.parseInt(num1);
        }
        if(num2.charAt(0)>='A'&&num2.charAt(0)<='Z'){
            ans+=map.getOrDefault(num2,0);

        }else{
            ans+=Integer.parseInt(num2);
        }
        return ans;

    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */