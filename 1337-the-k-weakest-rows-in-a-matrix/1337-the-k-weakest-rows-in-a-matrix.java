class Solution {
    class Row implements Comparable<Row>{
        int soliders;
        int index;

        public Row(int soliders, int index) {
            this.soliders = soliders;
            this.index = index;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soliders== r2.soliders){
                return this.index-r2.index;
            }else {
                return this.soliders-r2.soliders;
            }
        }
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq=new PriorityQueue<>();
        for (int i = 0; i <mat.length ; i++) {
            int count=0;
            for (int j = 0; j <mat[i].length ; j++) {
                if(mat[i][j]==1){
                    count++;
                }
            }
            pq.add(new Row(count,i));
        }
        int[] ans =new int[k];
        for (int i = 0; i <k ; i++) {
            ans[i]=pq.remove().index;
        }
        return ans;
    }
}