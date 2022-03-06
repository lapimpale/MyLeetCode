class Solution {
    public long minimalKSum(int[] arr, int k) {
        long ans = 0;
        int last = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= last + 1) {
                last = arr[i];
                continue;
            }
            int missing = arr[i] - last - 1;

            if (missing <= k) {
                ans += sum(last + 1, arr[i] - 1);
                k -= missing;
            } else {
                ans += sum(last + 1, last + k);
                k = 0;
                break;
            }
            last = arr[i];
        }
        if (k > 0) {
            ans += sum((long) arr[arr.length - 1] + 1, (long) arr[arr.length - 1] + k);
        }

        return ans;
    }

    private long sum(long lo, long hi) {
        return (lo + hi) * (hi - lo + 1) / 2;
    }
}