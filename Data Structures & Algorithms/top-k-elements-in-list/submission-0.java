class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
          int[] keys = new int[map.size()];
          int index = 0;

        for (int key : map.keySet()) {
            keys[index] = key;
            index++;
        }

        for (int i = 0; i < keys.length; i++) {

            for (int j = i + 1; j < keys.length; j++) {

                if (map.get(keys[i]) < map.get(keys[j])) {

                    int temp = keys[i];
                    keys[i] = keys[j];
                    keys[j] = temp;
                }
            }
        }


        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = keys[i];
        }

        return result;
    }
}
