class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n:
            n &= (n - 1)
            count += 1
        return count

# Testing the code with the provided examples
if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    n1 = 11
    print(f"Input: {n1} | Output: {sol.hammingWeight(n1)}")
    
    # Example 2
    n2 = 128
    print(f"Input: {n2} | Output: {sol.hammingWeight(n2)}")
    
    # Example 3
    n3 = 2147483645
    print(f"Input: {n3} | Output: {sol.hammingWeight(n3)}")
