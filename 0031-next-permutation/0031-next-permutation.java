class Solution {
      void swap(int[] nums,int i,int j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

        void reverse(int[] nums,int start){
            int i=start;
            int j=nums.length-1;
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }

        public void nextPermutation(int[] nums) 
        {
            int ind = -1;
            int n = nums.length;
            for(int i = n-2; i >= 0 ; i--)
            {
                if(nums[i] < nums[i + 1])
                {
                ind = i;
                break;
                }
            }
        if(ind == -1)
        {
            reverse(nums, 0);
            return;
        }
        for(int i = n - 1; i >= ind; i--)
        {
            if(nums[i] > nums[ind])
            {
                swap(nums, ind, i);
                break;              
                }
        }
        reverse(nums, ind + 1);
            
        }
}