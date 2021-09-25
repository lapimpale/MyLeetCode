class Solution {
    public boolean canJump(int[] nums) {
          // Last place is safe place because we can reach to destination from there by not moving.
        int safePlace = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            /*
             * Is it possible to reach to the safe place from current position i.e. - 'i' with the number of jump
             * allowed from here i.e. nums[i].   If possible then we can mark the current position as safe place.
             * Meaning previous elements has to reach this place or more(if more then it's allowed to reach here also)
             * to reach destination.
             */
            if (nums[i] + i >= safePlace) {
                safePlace = i;
            }
        }
        // If we are abel to make it safe place will be the start position. Else some other position.
        if (safePlace == 0) {
            return true;
        } else {
            return false;
        }
    }
}