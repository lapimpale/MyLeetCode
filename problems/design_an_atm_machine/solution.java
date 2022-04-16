class ATM {
	private long[] count = new long[5];

	public void deposit(int[] banknotesCount) {
		for (int i = 0; i < 5; i++) {
			count[i] += banknotesCount[i];
		}
	}

	public int[] withdraw(int amount) {
		int[] result = new int[5];
		for (int i = 4; i >= 0; i--) {
			amount -= new int[] { 20, 50, 100, 200, 500 }[i]
					* (result[i] = (int) Math.min(count[i], amount / new int[] { 20, 50, 100, 200, 500 }[i]));
		}
		if (amount > 0) {
			return new int[] { -1 };
		}
		for (int i = 0; i < 5; i++) {
			count[i] -= result[i];
		}
		return result;
	}
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */