class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void solve(int[] arr, int start, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) break;              // sorted -> no point going further
            if (i > start && arr[i] == arr[i - 1]) continue; // skip duplicate picks at this level
            temp.add(arr[i]);
            solve(arr, i + 1, target - arr[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}





// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
//         List<List<Integer>> result = new ArrayList<>();
//         solve(candidates,0,target,new ArrayList<Integer>(),result);
//         Set<List<Integer>> rs = new HashSet<>(result);
//         List<List<Integer>> frs = new ArrayList<>(rs);
//         return frs;
        
//     }
//     public void solve(int[]arr,int i,int target,List<Integer> temp,List<List<Integer>> result){
//             if(target == 0){
//                 result.add(new ArrayList<Integer>(temp));
//             }
//             if(i==arr.length||target<0){
//                 return;
//             }
//             temp.add(arr[i]);
//             solve(arr,i+1,target-arr[i],temp,result);
//             temp.remove(temp.size()-1);
//             solve(arr,i+1,target,temp,result);
//         }
// }
