class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }
    public static int [] mergeSort (int [] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length >> 1;
        return merge (
            mergeSort(Arrays.copyOfRange(arr, 0, mid)),
            mergeSort(Arrays.copyOfRange(arr, mid, arr.length))
        );
    }
    public static int [] merge (int[] a, int[] b) {
        int [] res = new int [a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            res[k++] = a[i] < b[j] ? a[i++] : b[j++];
        while (i < a.length)
            res[k++] = a[i++];
        while (j < b.length)
            res[k++] = b[j++];
        return res;
    }
}