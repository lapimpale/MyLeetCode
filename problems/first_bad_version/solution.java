/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1,
            right = n;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (isFirstBadVersion(mid)) {
                return mid;
            }
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n;
    }
    
    private boolean isFirstBadVersion(int version) {
        return isBadVersion(version) &&
            (version == 1 || !isBadVersion(version - 1));
    }
}