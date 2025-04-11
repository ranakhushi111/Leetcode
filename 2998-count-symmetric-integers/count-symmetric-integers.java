class Solution {
    public int countSymmetricIntegers(int low, int high) {
     int count = 0;
        
        for (int num = low; num <= high; num++) {
            String str = String.valueOf(num);
            int len = str.length();
            
            // Only consider numbers with even number of digits
            if (len % 2 != 0) continue;
            
            int mid = len / 2;
            int leftSum = 0, rightSum = 0;
            
            for (int i = 0; i < mid; i++) {
                leftSum += str.charAt(i) - '0';
                rightSum += str.charAt(i + mid) - '0';
            }
            
            if (leftSum == rightSum) count++;
        }
        
        return count;   
    }
}