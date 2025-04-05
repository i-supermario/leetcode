class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        int i = 0;
        boolean isNegative = false;
        // Get sign
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i)=='+')){
            isNegative = s.charAt(i) == '-';
            i++;
        }

        // Skip leading zeros
        while(i < s.length() && s.charAt(i) == '0') i++;

        int result = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){

            int val = s.charAt(i) - '0';
            if( result > (Integer.MAX_VALUE - val)/10 ){
               
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                 
            } 
            result = result*10 + val;
            i++;

        }


        return isNegative ? -result : result;



        
    }
}