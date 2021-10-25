class Solution {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
    //1 4 5 9 10 40 50 90 100 400 500 900 1000
    String[] Roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    while (num > 0) {
      if (num >= 1000) {
        builder.append(Roman[12]);
        num -= 1000;
      } else if (num >= 900) {
        builder.append(Roman[11]);
        num -= 900;
      } else if (num >= 500) {
        builder.append(Roman[10]);
        num -= 500;
      } else if (num >= 400) {
        builder.append(Roman[9]);
        num -= 400;
      } else if (num >= 100) {
        builder.append(Roman[8]);
        num -= 100;
      } else if (num >= 90) {
        builder.append(Roman[7]);
        num -= 90;
      } else if (num >= 50) {
        builder.append(Roman[6]);
        num -= 50;
      } else if (num >= 40) {
        builder.append(Roman[5]);
        num -= 40;
      } else if (num >= 10) {
        builder.append(Roman[4]);
        num -= 10;
      } else if (num >= 9) {
        builder.append(Roman[3]);
        num -= 9;
      } else if (num >= 5) {
        builder.append(Roman[2]);
        num -= 5;
      } else if (num >= 4) {
        builder.append(Roman[1]);
        num -= 4;
      } else if (num >= 1) {
        builder.append(Roman[0]);
        num -= 1;
      }
    }
    return builder.toString();
    }
}