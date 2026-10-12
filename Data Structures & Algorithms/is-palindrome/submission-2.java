class Solution {
    public boolean isPalindrome(String s) {
       String result = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j =result.length()-1;
        while(i < j){
            if(result.charAt(i) != result.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}




// int i = 0, j = s.length() - 1;

// while (i < j) {
//     while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
//     while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

//     if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
//         return false;
//     }
//     i++;
//     j--;
// }
// return true;