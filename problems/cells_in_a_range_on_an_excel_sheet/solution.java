class Solution {
    public List<String> cellsInRange(String s) {
	    var a = new ArrayList<String>();
	    for (var c = 'A'; c <= 'Z'; c++) {
	        for (var r = '1'; r <= '9'; r++) {
		        if (r >= s.charAt(1) && r <= s.charAt(4) && c >= s.charAt(0) && c <= s.charAt(3)) {
		            a.add("" + c + r);
		        }
	        }
	    }
	return new ArrayList<String>(a);
    }
}