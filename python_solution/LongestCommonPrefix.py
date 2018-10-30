class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        result = ""
        
        if (strs is None or len(strs) == 0):
            return result
        
        firstWord = strs[0]
        
        for i in range(0, len(firstWord)):
            for j in range(1, len(strs)):
                if (i >= len(strs[j]) or strs[j][i] != firstWord[i]):
                    return result
                
            result = result + firstWord[i]
            
        return result