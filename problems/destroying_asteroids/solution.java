class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = (long) mass;
        for(int i=0; i< asteroids.length;i++){
            if(asteroids[i] <= currentMass) currentMass+=asteroids[i];
            else return false;
        }       
        return true;
    }
}