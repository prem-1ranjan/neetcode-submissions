class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>>result = new ArrayList<>();
         solve(nums,0,target,new ArrayList<>(),result);
        return result ;
    }
    public void solve(int[]nums,int i,int target,List<Integer> ans,List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList<Integer>(ans));
            return;
        }
        if(i==nums.length || target<0){
            return;
        }
        ans.add(nums[i]);
        solve(nums,i,target-nums[i],ans,result);
        ans.remove(ans.size()-1);
        solve(nums,i+1,target,ans,result);
       
    }
}
