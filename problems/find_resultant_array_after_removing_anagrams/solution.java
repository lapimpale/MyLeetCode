class Solution {

	public List<String> removeAnagrams(String[] words) {
		ArrayList<String> list = new ArrayList<>(List.of(words[0]));
		for (int i = 1; i < words.length; i++) {
			if (!Arrays.equals(words[i].chars().sorted().toArray(), words[i - 1].chars().sorted().toArray())) {
				list.add(words[i]);
			}
		}
		return list;
	}
}