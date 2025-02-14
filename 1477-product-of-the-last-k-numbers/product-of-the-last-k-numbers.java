class ProductOfNumbers {
    List<Integer> list;
    int length;
    int n;
    public ProductOfNumbers() {
        list = new ArrayList();
        length = 0;
        n=0;
    }
    
    public void add(int num) {
        if(num==0){
            list.add(num);
            length = 0;
        }
        else{
            if(length>0){
                list.add(num*list.get(n-1));
            }
            else{
                list.add(num);
            }
            length++;
        }
        n++;
    }
    
    public int getProduct(int k) {
        if(length<k){
            return 0;
        }
        else{
            if(length==k){
                return list.get(n-1);
            }
            else{
                return list.get(n-1)/list.get(n-1-k);
            }
        }
        
    }   
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */