class Solution {

	public String removeDigit(String number, char digit) {
		String result = "";
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == digit && result.compareTo(number.substring(0, i) + number.substring(i + 1)) < 0) {
				result = number.substring(0, i) + number.substring(i + 1);
			}
		}
		return result;
	}
}