class Solution:
    def reverse(self, x: int) -> int:
        
        MIN_INT, MAX_INT = -2**31, 2**31 - 1
        
       
        sign = -1 if x < 0 else 1
        res_str = str(abs(x))[::-1]
        res = int(res_str) * sign
        
    
        if res < MIN_INT or res > MAX_INT:
            return 0
            
        return res
