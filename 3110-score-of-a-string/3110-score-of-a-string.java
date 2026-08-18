class Solution {
    public int scoreOfString(String s) {
        int sum = 0, n=s.length();
        for(int i = 0; i<n-1; i++)
        {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i+1);
            sum += Math.abs(ch-ch1);
        }
        return sum;
    }
}