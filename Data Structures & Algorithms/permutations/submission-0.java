class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums, used, new ArrayList<Integer>(), result);
        return result;
    }

    private void solve(int[] nums, boolean[] used, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;      // skip numbers already in this permutation
            used[i] = true;
            ans.add(nums[i]);

            solve(nums, used, ans, result);

            ans.remove(ans.size() - 1); // backtrack
            used[i] = false;
        }
    }
}