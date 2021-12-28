class Solution {
    public String minRemoveToMakeValid(String s) {
		String[] arr = s.split("");

		Stack<String> p = new Stack<>();
		Stack<Integer> index = new Stack<>();

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String t = arr[i];

			if (t.equals("(")) {
				answer.add(" ");

				p.add(t);
				index.add(i);
			} else if (t.equals(")")) {
				if (p.isEmpty()) {
					answer.add(" ");
					continue;
				}

				if(p.peek().equals("(")) {
					answer.set(index.pop(), p.pop());
					answer.add(t);
				}
			} else {
				answer.add(t);
			}
		}

		return answer.stream()
			.filter(i -> !i.equals(" "))
			.collect(Collectors.joining());
	}
}