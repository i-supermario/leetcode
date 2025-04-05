class Solution {
    public int reverse(int x) {

        String str = String.valueOf(x);
        boolean isNegative = false;
        if(str.charAt(0) == '-'){
            str = str.substring(1);
            isNegative = true;
        }
        int i=str.length() - 1;
        int result = 0;
        while(i>=0){
            int val = str.charAt(i) - '0';
            if(result > (Integer.MAX_VALUE - val)/10){
                return 0;
            }
            result = result * 10 + val;
            i--;
        }

        return isNegative ? -result : result;
        
    }
}