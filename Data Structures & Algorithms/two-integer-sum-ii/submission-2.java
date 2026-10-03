class Solution {
        
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; i++) {
            while (i < j && numbers[i] + numbers[j] < target) {
                i++;
            }
            
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                int[] res = new int[2];
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
            
        }
        return new int[2];
    }
}



//-------------------------------------------------------------------------------------


// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] result = new int[2];
//         int i = 0;  //Pointer one
//         int j = numbers.length - 1; // Pointer 2
        
        
//         while(true){
//             if (numbers[i] + numbers[j] > target) j--;
//             else if (numbers[i] + numbers[j] < target) i++;
//             else{
//                 result[0] = i+1;
//                 result[1] = j+1;
//                 return result;
//             }
//         }
        


//     }
// }

//----------------------------------------------------------------------------

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         Map<Integer,Integer> map = new HashMap<>();
//         for(int i = 0;i<numbers.length;i++){
//             int val = target - numbers[i];
//             if(map.containsKey(val)){
//                 return new int[]{map.get(val),i+1};
                
//             }
//             map.put(numbers[i],i+1);
//         }
//         return new int[]{};
//     }
// }
