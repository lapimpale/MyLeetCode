class Solution {
    public int totalSteps(int[] nums) {
        int N = nums.length;
        TreeSet<Integer> alive = new TreeSet<>();
        for (int i = 0; i < N; i++) alive.add(i);
        
        ArrayList<Integer> kill = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (nums[i] < nums[i-1]) {
                kill.add(i);
            }
        }
        //System.out.println(kill);
        
        int ans = 0;
        while (!kill.isEmpty()) {
            ans++;
            for (int k: kill) {
                alive.remove(k);
            }
            ArrayList<Integer> newKill = new ArrayList<>();
            for (int k: kill) {
                Integer next = alive.higher(k);
                if (next != null) {
                    Integer prev = alive.lower(k);
                    if (prev != null && nums[next] < nums[prev]) {
                        newKill.add(next);
                    }
                }
            }
            kill = newKill;
        }
        return ans;
    }
}