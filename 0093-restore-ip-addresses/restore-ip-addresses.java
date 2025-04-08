class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        backtrack(0,s,result,new ArrayList<>());
        return result;

    }

    void backtrack(int start, String s, List<String> result, List<String> temp){

        if(start > s.length()) return;
        if(temp.size() == 4 && start == s.length()){
            result.add(String.join(".", temp));
            return;
        }

        for(int end = start + 1;end <= Math.min(start + 3, s.length());end++){

            if(isValid(s.substring(start,end)) && temp.size() < 4){
                temp.add(s.substring(start,end));
                backtrack(end, s, result, temp);
                temp.remove(temp.size() - 1);
            }

        }

        return;

    }

    boolean isValid(String s){
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;

    }
}