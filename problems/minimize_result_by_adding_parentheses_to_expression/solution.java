class Solution {

	public String minimizeResult(String expression) {
		String result = "", split[] = expression.split("\\+");
		for (int i = 0, min = Integer.MAX_VALUE; i < split[0].length(); i++) {
			for (int j = 1; j <= split[1].length(); j++) {
				int curr = (i > 0 ? Integer.parseInt(split[0].substring(0, i)) : 1)
						* (Integer.parseInt(split[0].substring(i)) + Integer.parseInt(split[1].substring(0, j)))
						* (j < split[1].length() ? Integer.parseInt(split[1].substring(j)) : 1);
				if (curr < min) {
					min = curr;
					result = split[0].substring(0, i) + '(' + split[0].substring(i) + '+' + split[1].substring(0, j)
							+ ')' + split[1].substring(j);
				}
			}
		}
		return result;
	}
}