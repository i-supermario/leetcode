class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        while(num != 0){
            if(num / 1000 > 0){

                int multiplier = num / 1000;
                int value = multiplier * 1000;
                while(multiplier > 0){
                    sb.append("M");
                    multiplier--;
                }
                num -= value;

            }
            else if(num / 500 > 0 ){
                if(num / 900 > 0){
                    sb.append("CM");
                    num -= 900;
                }
                else{

                    sb.append("D");
                    num -= 500;
                }

            }

            else if( num / 100 > 0){
                if(num / 400 > 0){
                    sb.append("CD");
                    num -= 400;
                }
                else{
                    int multiplier = num / 100;
                    int value = multiplier * 100;
                    while(multiplier > 0){
                        sb.append("C");
                        multiplier--;
                    }
                    num -= value;
                }

            }
            else if(num / 50 > 0 ){
                if(num / 90 > 0){
                    sb.append("XC");
                    num -= 90;
                }
                else{

                    sb.append("L");
                    num -= 50;
                }

            }
            else if( num / 10 > 0){

                if(num / 40 > 0){
                    sb.append("XL");
                    num -= 40;
                }
                else{

                    int multiplier = num / 10;
                    int value = multiplier * 10;
                    while(multiplier > 0){
                        sb.append("X");
                        multiplier--;
                    }
                    num -= value;

                }

            }
            else if(num / 5 > 0 ){
                if(num / 9 > 0){
                    sb.append("IX");
                    num -= 9;
                }
                else{

                    sb.append("V");
                    num -= 5;
                }

            }
            else {

                if(num / 4 > 0){
                    sb.append("IV");
                    num -= 4;
                }
                else{
                    int multiplier = num / 1;
                    int value = multiplier * 1;
                    while(multiplier > 0){
                        sb.append("I");
                        multiplier--;
                    }
                    num -= value;
                }

            }


        }

        return sb.toString();
        
    }
}