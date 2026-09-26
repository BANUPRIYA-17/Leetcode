

class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            mid = left + (right - left) // 2
            res = guess(mid)
            if res == 0:
                return mid   # Found the pick
            elif res < 0:
                right = mid - 1  # Pick is lower
            else:
                left = mid + 1   # Pick is higher
