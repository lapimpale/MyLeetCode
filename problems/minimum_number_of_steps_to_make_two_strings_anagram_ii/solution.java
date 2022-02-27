class Solution {
    public int minSteps(String s, String t) {
	var f = new int[26];
	var r = 0;
	for (var c : s.toCharArray())
	    f[c - 'a']++;
	for (var c : t.toCharArray())
	    f[c - 'a']--;
	for (var i = 0; i < 26; i++)
	    r += Math.abs(f[i]);
	return r;
    }
}