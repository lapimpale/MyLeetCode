class Solution {
    int x=0, y=0;
int[] direction = new int[3];

public boolean isRobotBounded(String instructions) {
    
    if(!instructions.contains("G")){
        return true;
    }
    
    int currentIndex = 0;
    for(int i =0; i<direction.length; i++){
        direction[i] = i;
    }

    for(int i =0; i<instructions.length(); i++){
        char c = instructions.charAt(i);
        switch(c){
            case 'G' : moveRobot(currentIndex);
                     break;
             case 'L' : currentIndex = turnRobot(c, currentIndex);
                 break;
             case 'R' :currentIndex = turnRobot(c, currentIndex);
                 break;
            default:
                break;

        }
    }
    
    return ((x == 0 && y == 0) || currentIndex != 0);
}

private void moveRobot(int currentIndex){
    if(currentIndex == 0){
        y += 1;
    }else if(currentIndex == 1){
        x -= 1;
    }else if(currentIndex == 2){
        y -= 1;
    }else if(currentIndex == 3){
        x += 1;
    }
        
}

/**
This method is used to get the currentIndex
*/
private int turnRobot(char c, int currentIndex){
    
    if(c == 'L'){
        currentIndex = (currentIndex == 3)?0:currentIndex+1; 
    }else if(c == 'R'){
        currentIndex = (currentIndex == 0)?3:currentIndex-1;
    }
    return currentIndex; 
}
}