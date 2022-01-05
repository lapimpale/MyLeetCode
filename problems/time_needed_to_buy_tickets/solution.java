class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
	    int time = 0;
	    for (int i = 0; i < tickets.length; i++) {
		    time += Math.min(i <= k ? tickets[k] : tickets[k] - 1, tickets[i]);
	    }
	return time;
    }
}