import java.util.ArrayList;

class Solution {
    public int minimumFinishTime(int[][] tires, long changeTime, int numLaps) {
	var t = new ArrayList<Long>();
	for (var i = 0; i < 25; i++)
	    t.add((long) Integer.MAX_VALUE);
	for (var v : tires) {
	    var c = (long) v[0];
	    var p = 0L;
	    for (var i = 1; i < 25; i++) {
		t.set(i, Math.min(t.get(i), changeTime + (p += c)));
		if ((c *= v[1]) > Integer.MAX_VALUE)
		    break;
	    }
	}
	var d = new ArrayList<Long>();
	for (var i = 0; i <= numLaps; i++)
	    d.add((long) Integer.MAX_VALUE);
	d.set(0, -changeTime);
	for (var i = 1; i <= numLaps; i++)
	    for (var j = 1; j <= i && j < 25; j++)
		d.set(i, Math.min(d.get(i), t.get(j) + d.get(i - j)));
	return d.get(numLaps).intValue();
    }
}