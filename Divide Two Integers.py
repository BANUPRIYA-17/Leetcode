class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        
        if dividend == -2147483648 and divisor == -1:
            return 2147483647
        
        
        is_negative = (dividend < 0) != (divisor < 0)
        
        
        a, b = abs(dividend), abs(divisor)
        quotient = 0
        
        
        while a >= b:
            temp_divisor = b
            multiple = 1
            
            while a >= (temp_divisor + temp_divisor):
                temp_divisor += temp_divisor
                multiple += multiple
            
            a -= temp_divisor
            quotient += multiple
            
     
        return -quotient if is_negative else quotient
