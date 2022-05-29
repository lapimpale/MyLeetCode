class Solution {
    
    public boolean isValidPrice(String str) {
        if(str.length() <= 1 || !str.startsWith("$")) 
            return false;
        for(int i=1;i<str.length();i++) {
            if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) return false;
        }
        return true;
    }
    
    public double getPrice(String token) {
        return Double.parseDouble(token.substring(1));
    }
    
    public double getValueAfterDiscount(double price, int discount) {
        
        return price - (price*discount)/100d;
    }
    
    public String discountPrices(String sentence, int discount) {
        
        String[] tokens = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(String token: tokens) {
            
            if(isValidPrice(token)) {
                
                double valueAfterDiscount = getValueAfterDiscount(getPrice(token), discount);
                sb.append(" $" + String.format("%.2f", valueAfterDiscount));
            } else {
                sb.append(" " + token);
            }
        }
        
        return sb.toString().substring(1);
    }
}