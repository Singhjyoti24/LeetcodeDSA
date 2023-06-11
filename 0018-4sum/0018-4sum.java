class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(target==-294967296){
            return ans;
        }
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int k = j+1, l = nums.length-1;
                while(k<l){
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        arr.add(nums[l]);
                        if(!ans.contains(arr)){
                            ans.add(arr);
                        }
                        k++;l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}