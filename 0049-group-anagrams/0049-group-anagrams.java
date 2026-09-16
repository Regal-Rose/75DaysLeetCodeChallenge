import java.util.*;

class Solution {
    private void isAnagram(String[] strs, int[] baseFreq, int startIdx, List<String> group) {
        for (int i = startIdx; i < strs.length; i++) {
            if (strs[i] == null) continue; 
            if (strs[i].length() != group.get(0).length()) continue; 

            int[] freq = new int[26];
            for (char c : strs[i].toCharArray()) {
                freq[c - 'a']++;
            }

            if (Arrays.equals(baseFreq, freq)) {
                group.add(strs[i]);
                strs[i] = null; 
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;

            int[] freq = new int[26];
            for (char c : strs[i].toCharArray()) {
                freq[c - 'a']++;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            strs[i] = null; 

            isAnagram(strs, freq, i + 1, group);
            result.add(group);
        }

        return result;
    }
}
