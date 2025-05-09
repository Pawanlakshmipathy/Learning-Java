import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;
        
        if (s.length() < totalLength) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            int count = 0;
            
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                    }
                    
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return result;
    }
}