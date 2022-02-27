class Solution {
    public long minimumTime(int[] time, int totalTrips) {
	var l = 1L;
	var h = (long) 1e14;
	while (l < h)
	    if (p(l + (h - l) / 2, time, totalTrips) != 0)
		h = l + (h - l) / 2;
	    else
		l = l + (h - l) / 2 + 1;
	return l;
    }

    public final long p(Long t, int[] time, long totalTrips) {
	for (var i : time)
	    if ((totalTrips -= t / i) <= 0)
		return 1;
	return 0;
    }
}