class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        boxes = [0] * 26
        for char in s:
            position = ord(char) - ord('a')
            boxes[position] = boxes[position] + 1
        for char in t:
            position = ord(char) - ord('a')
            boxes[position] = boxes[position] - 1
        for count in boxes:
            if count != 0:
                return False
        return True
