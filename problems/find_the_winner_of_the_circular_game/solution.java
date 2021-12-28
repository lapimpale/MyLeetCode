class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] visited = new boolean[n];
        int totalCount = 0;
        int i = 0;
        int count = 0;
		
        while( (n - totalCount) != 1){
            if(visited[i]){
                i = (i+1)%n;
                continue; 
            }
            count++;
            if(count%k == 0){
                visited[i] = true;
                count = 0;
                totalCount++;
            }
            i = (i+1)%n;
        }

        for(int j = 0 ; j < visited.length ; j++){
            if(!visited[j]){
                return j+1; 
            }
        }
        return -1;
    }
}