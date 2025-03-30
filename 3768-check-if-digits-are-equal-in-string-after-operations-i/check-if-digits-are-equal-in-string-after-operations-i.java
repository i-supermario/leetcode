class Solution {
    public boolean hasSameDigits(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 2){

            StringBuilder ob = new StringBuilder();

            for(int i=0;i<sb.length()-1;i++){
                int num1 = sb.charAt(i) - '0';
                int num2 = sb.charAt(i+1) - '0';
                int ans = (num1 + num2) % 10;

                ob.append((char)('0' + ans));
            }

            sb = ob;

        }

        return sb.charAt(0) == sb.charAt(1);

    }
}