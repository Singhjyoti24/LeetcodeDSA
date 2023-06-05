class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0, k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                map.put(nums1[i], 1);
                i++;j++;
            }
        }
        
        int[] ans = new int[map.size()];
        for(Integer si: map.keySet()){
            ans[k++] = si;
        }
        
        return ans;
    }
}