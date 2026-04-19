class Solution {
    public int findGCD(int[] nums) {
       int min = nums[0] ;
       int max = nums[0];
       for(int i : nums){
         if(i<min) min=i;
        if(i>max) max=i;
       }
       return gcd(min,max);
    }
     
     public int gcd(int a, int b){
        while(a!=b){
            if(a>b){
                a=a-b;
            }
            else{
                b=b-a;
            }
           
        }
         return a;
     }
     }
