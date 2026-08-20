class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] nums, int i, List<Integer> temp, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(nums, i + 1, temp, result);
        temp.remove(temp.size() - 1);
        solve(nums, i + 1, temp, result);
    }
}


// temp.add(1);
// result.add(new ArrayList<>(temp));   // GOOD: [1] ki ek independent COPY bani

// temp.add(2);   // temp = [1,2], but result wali copy [1] hi rahegi, safe hai

// ==================================================================================================
// i=0: temp.add(1)     → temp = [1]
//   i=1: temp.add(2)   → temp = [1,2]
//     i=2: temp.add(3) → temp = [1,2,3]
//       i=3: base case! result mein [1,2,3] ki COPY add hui
//            result = [[1,2,3]]
//            temp abhi bhi [1,2,3] hai (kuch remove nahi hua yahan)

//       temp.remove(last) → temp = [1,2]   ← 3 hata diya (backtrack)
//       i=3 firse call (not-take 3): base case!
//            result mein [1,2] ki COPY add hui
//            result = [[1,2,3], [1,2]]
//            temp abhi bhi [1,2] hai
//            =2: temp = [1,2] (abhi tak, 3 hata chuke hain)
//   temp.remove(last) → temp = [1]     ← 2 hata diya (backtrack from i=2 level)

//   i=2 firse call (not-take 2 ka andar wala not-take 3):
//     i=2: temp.add(3) → temp = [1,3]
//       i=3: base case! result mein [1,3] ki COPY add hui
//            result = [[1,2,3], [1,2], [1,3]]
//            temp abhi bhi [1,3] hai

//       temp.remove(last) → temp = [1]   ← 3 hata diya
//       i=3 firse call (not-take 3): base case!
//            result mein [1] ki COPY add hui
//            result = [[1,2,3], [1,2], [1,3], [1]]
//            temp abhi bhi [1] hai

//   ← ab i=1 level se bhi wapas aa gaye (i=1 ke saare calls complete)

// i=1 level pe:
//   temp.remove(last) → temp = []      ← 1 hata diya (backtrack from i=1 level)

//   i=1 firse call (not-take 1 ka poora subtree — same jaisa upar hua, but bina 1 ke):
//     i=1: temp.add(2) → temp = [2]
//       i=2: temp.add(3) → temp = [2,3]
//         i=3: base case! result mein [2,3] add hua
//              result = [..., [2,3]]
//              temp = [2,3]

//         temp.remove(last) → temp = [2]
//         i=3 firse (not-take 3): base case!
//              result mein [2] add hua
//              result = [..., [2,3], [2]]
//              temp = [2]

//       temp.remove(last) → temp = []   ← 2 hata diya
//       i=2 firse call (not-take 2):
//         i=2: temp.add(3) → temp = [3]
//           i=3: base case! result mein [3] add hua
//                result = [..., [3]]
//                temp = [3]

//           temp.remove(last) → temp = []
//           i=3 firse (not-take 3): base case!
//                result mein [] add hua
//                result = [..., []]
//                temp = []

