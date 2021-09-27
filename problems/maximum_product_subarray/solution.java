class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1,
            minProd = 1,
            overallMax = Integer.MIN_VALUE;
        for (int num : nums) {
            overallMax = Math.max(overallMax, num);
        }
        for (int num : nums) {
            if (num == 0) {
                maxProd = 1;
                minProd = 1;
                continue;
            }
            int maxProdTimesNum = maxProd * num,
                minProdTimesNum = minProd * num;
            maxProd = Math.max(Math.max(maxProdTimesNum, minProdTimesNum), num);
            minProd = Math.min(Math.min(maxProdTimesNum, minProdTimesNum), num);
            overallMax = Math.max(overallMax, maxProd);
        }
        return overallMax;
    }
}