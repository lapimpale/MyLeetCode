class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
int limit = Math.max(m,n);
long res = 1;
int j = 1;
for(int i = N ; i>=limit ; i--){
res = (res * i)/j;
j++;
}
return Long.valueOf(res).intValue();
    }
}