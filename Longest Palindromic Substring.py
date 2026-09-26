class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # Check odd palindromes (e.g., "aba")
            tmp1 = self.expand(s, i, i)
            if len(tmp1) > len(res):
                res = tmp1
                
            # Check even palindromes (e.g., "abba")
            tmp2 = self.expand(s, i, i + 1)
            if len(tmp2) > len(res):
                res = tmp2
        return res

    def expand(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1 : right]
