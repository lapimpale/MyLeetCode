public class Solution {
  public boolean isMatch(String s, String p) {
    if (s == null && p == null) {
      return true;
    }
    if (s == null || p == null) {
      return false;
    }
    boolean [][] dp = new boolean [s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); ++i) {
      dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i];
    }
    for (int i = 0; i < s.length(); ++i) {
      for (int j = 0; j < p.length(); ++j) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i][j];
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}