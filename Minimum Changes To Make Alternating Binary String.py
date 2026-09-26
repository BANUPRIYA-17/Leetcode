class Solution:
    def minOperations(self, s: str) -> int:
        # Case 1: String starts with '0' → pattern "010101..."
        ops1 = 0
        for i, ch in enumerate(s):
            expected = '0' if i % 2 == 0 else '1'
            if ch != expected:
                ops1 += 1

        # Case 2: String starts with '1' → pattern "101010..."
        ops2 = 0
        for i, ch in enumerate(s):
            expected = '1' if i % 2 == 0 else '0'
            if ch != expected:
                ops2 += 1

        # Minimum operations between the two patterns
        return min(ops1, ops2)


# Example usage:
solution = Solution()
print(solution.minOperations("0100"))   # Output: 1
print(solution.minOperations("10"))     # Output: 0
print(solution.minOperations("1111"))   # Output: 2
