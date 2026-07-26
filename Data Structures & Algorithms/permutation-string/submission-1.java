class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1_fr = new int[26];
        int []s2_fr = new int[26];
        for(int i = 0;i<s1.length();i++){
            s1_fr[s1.charAt(i)-'a']++;
        }
        int i =0;
        int j=0;
        while(j<s2.length()){
            s2_fr[s2.charAt(j)-'a']++;
            
            if(j-i+1>s1.length()){
                s2_fr[s2.charAt(i) - 'a']--;
                i++;
            }
            j++;
            if(Arrays.equals(s1_fr,s2_fr)){
                return true;
            }
        }
        return false ;

    }
}