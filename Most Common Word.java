import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        String mostFrequentWord = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            int currentCount = wordCounts.getOrDefault(word, 0) + 1;
            wordCounts.put(word, currentCount);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentWord = word;
            }
        }

        return mostFrequentWord;
    }
}
