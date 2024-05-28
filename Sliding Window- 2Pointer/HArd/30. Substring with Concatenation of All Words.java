class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
    if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

    HashMap<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    int wordLength = words[0].length();
    int wordsLength = words.length;
    int totalLength = wordLength * wordsLength;

    for (int i = 0; i <= s.length() - totalLength; i++) {
        HashMap<String, Integer> seenWords = new HashMap<>();
        int j = 0;
        while (j < wordsLength) {
            int startIndex = i + j * wordLength;
            String sub = s.substring(startIndex, startIndex + wordLength);
            if (wordCount.containsKey(sub)) {
                seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                if (seenWords.get(sub) > wordCount.get(sub)) break;
            } else {
                break;
            }
            j++;
        }
        if (j == wordsLength) res.add(i);
    }

    return res;
    }
}
