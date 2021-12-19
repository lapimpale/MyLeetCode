class Solution {
    public static List<Integer> findAnagrams(String s, String p) {

    if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
        return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();

    int[] input = new int[26];
    int[] pattern = new int[26];
    for (int i = 0; i < p.length(); i++) {
        pattern[p.charAt(i) - 'a']++;
        input[s.charAt(i) - 'a']++;
    }

    if (isAnagram(pattern, input)) {
        result.add(0);
    }
    int j = 0;

    int inputCount = 1;
    while (inputCount + p.length() - 1 < s.length()) {
        input[s.charAt(inputCount - 1) - 'a']--;
        input[s.charAt(inputCount + p.length() - 1) - 'a']++;
        if (isAnagram(pattern, input)) {
            result.add(inputCount);
        }
        inputCount++;
    }
    return result;
}

private static boolean isAnagram(int[] pattern, int[] input) {
    for (int i = 0; i < 26; i++) {
        if (pattern[i] != input[i]) {
            return false;
        }
    }
    return true;
}
}