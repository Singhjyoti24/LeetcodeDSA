class ProductOfNumbers {

    ArrayList<Integer> arr = new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int ans = 1;
        if(arr.size()>=k){
            int j = arr.size()-1;
            int i = 0;
            while(i!=k){
                ans *= arr.get(j);
                j--;
                i++;
            }
        }
        
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */