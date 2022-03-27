class Solution {

	public int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int[][] sum = new int[piles.size()][];
		for (int i = 0; i < piles.size(); i++) {
			sum[i] = new int[piles.get(i).size() + 1];
			for (int j = 0; j < piles.get(i).size(); j++) {
				sum[i][j + 1] = sum[i][j] + piles.get(i).get(j);
			}
		}
		return maxValueOfCoins(0, k, sum, new Integer[piles.size()][k + 1]);
	}

	private int maxValueOfCoins(int index, int k, int[][] sum, Integer[][] dp) {
		if (index == sum.length) {
			return 0;
		} else if (dp[index][k] == null) {
			dp[index][k] = 0;
			for (int i = 0; i <= k && i < sum[index].length; i++) {
				dp[index][k] = Math.max(dp[index][k], sum[index][i] + maxValueOfCoins(index + 1, k - i, sum, dp));
			}
		}
		return dp[index][k];
	}
}