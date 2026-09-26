class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_counts = {}
        for char in s:
            char_counts[char] = char_counts.get(char, 0) + 1
        
        length = 0
        has_odd = False
        
        for count in char_counts.values():
            
            length += (count // 2) * 2
            if count % 2 == 1:
                has_odd = True
        
       
        return length + 1 if has_odd else length
