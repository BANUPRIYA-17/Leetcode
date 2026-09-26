class Solution:

    def palindromePairs(self, words: list[str]) -> list[list[int]]:
        word_to_index = {word: i for i, word in enumerate(words)}
        result = []

        for i, word in enumerate(words):
            for j in range(len(word) + 1):
                prefix = word[:j]
                suffix = word[j:]

                if prefix == prefix[::-1]:
                    reversed_suffix = suffix[::-1]
                    if (
                        reversed_suffix in word_to_index
                        and word_to_index[reversed_suffix] != i
                    ):
                        result.append([word_to_index[reversed_suffix], i])

                if j < len(word) and suffix == suffix[::-1]:
                    reversed_prefix = prefix[::-1]
                    if (
                        reversed_prefix in word_to_index
                        and word_to_index[reversed_prefix] != i
                    ):
                        result.append([i, word_to_index[reversed_prefix]])

        return result
