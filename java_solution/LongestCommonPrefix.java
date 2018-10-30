class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        
        String firstWord = strs[0];
        
        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != firstWord.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(firstWord.charAt(i));
        }
        
        return sb.toString();
    }
}