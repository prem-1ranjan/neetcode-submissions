class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pdt = 1;
        int zero = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                pdt *= nums[i];
            }
            else zero++;
        }
        if(zero > 1){
            return new int [nums.length];
        }
        int [] result = new int[nums.length];
        for(int i =0 ; i<nums.length;i++){
            if(zero == 1){
                result[i] = (nums[i] == 0) ? pdt : 0;
            }
            else{
                result[i] = pdt/nums[i];
            }
        }
        return result;
    }
}  
