class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length, pos, cnt;
    	Arrays.sort(batteries); // Ascending sort
    	long[] sum = new long[m]; // Sum the left numbers
    	sum[0] = batteries[0];
    	for (int i = 1; i < m; i++)
    		sum[i] = batteries[i] + sum[i - 1];
    	long left = batteries[0], right = sum[m - 1] / n;
    	while (left <= right) {
    		long mid = (left + right) / 2;
    		// Retrieve all batteries greater than mid, and count the rest number of computers
			for (pos = m - 1, cnt = n; pos >= 0 && cnt > 0 && batteries[pos] >= mid; pos--, cnt--);
    		if (cnt == 0 || pos < 0 || sum[pos] >= mid * cnt) // enough batteries
    			left = mid + 1;
    		else // lack of batteries
    			right = mid - 1;
    	}
    	return right;
    }
}