class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        Arrays.sort(s1arr);
        String sorteds1 = new String(s1arr);

        for(int i = 0;i<s2.length();i++){
            for(int j = i;j<s2.length();j++){
                char[] subarr = s2.substring(i,j+1).toCharArray();
                Arrays.sort(subarr);
                String sortedString = new String(subarr);
                if(sortedString.equals(sorteds1)){
                    return true ;
                }
            }
        }
        return false;
    }
}
