class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
         List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(nums);
         solve(nums,0,new ArrayList<>(),result);
        
        return result;
    }
    void solve(int []nums,int index,List<Integer> ans,List<List<Integer>>result){
        if(index == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        solve(nums,index+1,ans,result);
        ans.remove(ans.size()-1);
        while(index+1<nums.length && nums[index] == nums[index+1]){
            index++;
        }
        solve(nums,index+1,ans,result);
    }

}
