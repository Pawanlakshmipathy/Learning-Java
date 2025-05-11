class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean hasDigit = false, hasDot = false, hasE = false;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (c == '.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasDigit) return false;
                hasE = true;
                hasDigit = false;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        
        return hasDigit;
    }
}
