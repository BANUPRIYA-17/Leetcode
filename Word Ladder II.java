import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) {
            return res;
        }
        
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Integer> visitedSteps = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visitedSteps.put(beginWord, 0);
        
        boolean found = false;
        int wordLen = beginWord.length();
        
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                int currStep = visitedSteps.get(currWord);
                
                char[] chars = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        chars[j] = c;
                        String nextWord = new String(chars);
                        
                        if (dict.contains(nextWord)) {
                            if (!visitedSteps.containsKey(nextWord)) {
                                visitedSteps.put(nextWord, currStep + 1);
                                queue.add(nextWord);
                                adjMap.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(currWord);
                            } 
                            else if (visitedSteps.get(nextWord) == currStep + 1) {
                                adjMap.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(currWord);
                            }
                            
                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    chars[j] = originalChar; 
                }
            }
        }
        
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, adjMap, path, res);
        }
        
        return res;
    }
    
    private void backtrack(String currWord, String beginWord, Map<String, List<String>> adjMap, 
                           List<String> path, List<List<String>> res) {
        if (currWord.equals(beginWord)) {
            List<String> correctOrderPath = new ArrayList<>(path);
            Collections.reverse(correctOrderPath);
            res.add(correctOrderPath);
            return;
        }
        
        if (adjMap.containsKey(currWord)) {
            for (String parent : adjMap.get(currWord)) {
                path.add(parent);
                backtrack(parent, beginWord, adjMap, path, res);
                path.remove(path.size() - 1); 
            }
        }
    }
}
