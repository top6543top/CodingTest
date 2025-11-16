class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long d_long = (long) d; 
        for (long x = 0; x <= d_long; x += k) {
            
            long y_max_squared = d_long * d_long - x * x;
        
            double y_max = Math.sqrt(y_max_squared);
            long count = (long) (y_max / k) + 1;
            answer += count;
        }
        
        return answer;
    }
}