class Solution {
    public boolean canReach(int[] arr, int start) {
         int[] visited = new int[arr.length];
        return dfs(arr,start,arr[start],visited) || dfs(arr,start,-arr[start],visited);
    }
    private boolean dfs(int[] arr, int prev, int jump, int[] visited)
    {
        int cur = prev + jump;
        if(cur >= arr.length || cur < 0)
            return false;
        if(arr[cur] == 0)
            return true;
        if(visited[cur] == 1)
            return false;
        visited[cur] = 1;
        return dfs(arr,cur,arr[cur],visited) || dfs(arr,cur,-arr[cur],visited);
    }
}