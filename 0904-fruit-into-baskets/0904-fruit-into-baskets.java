class Solution {
    public int totalFruit(int[] fruits) {
        // if(fruits.length==1){
        //     return 1;
        // }else if(fruits.length==2){
        //     if(fruits[0]==fruits[1]){
        //         return 1;
        //     }else{
        //         return 2;
        //     }
        // }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int j = 0, ans = 0;
        for(int i=0;i<fruits.length;i++){
            if(map.containsKey(fruits[i])){
                map.put(fruits[i], map.get(fruits[i])+1);
            }else{
                map.put(fruits[i], 1);
            }
            
            if(map.size()<=2){
                ans = Math.max(ans, i-j+1);
            }
            
            while(map.size()>2){
                if(map.get(fruits[j])>1){
                   map.put(fruits[j], map.get(fruits[j])-1);
                }else{
                   map.remove(fruits[j]);
                }
                j++;
            }
        }
        
        return ans;
    }
}