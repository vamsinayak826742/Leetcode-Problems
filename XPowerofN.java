/* Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104 */

/*Using In-built Math function */

 class Solution {
    public double myPow(double x, int n) {
        double res=Math.pow(x,n);
        return res;
    }
}

/* Normal Way to do -- not worked all cases*/

class Solution {
    public double myPow(double x, int n) {
        double res=x;
        int sign=0;
        if(n==0)
            return 1;
        if(n<0)
        {
            sign++;
            n*=-1;
        }
        for(int i=1;i<n;i++)
        {
            res*=x;
            
        }
        if(sign>0)
        {
            res=1/res;
        }
        return res;
    }
}


/*Efficient use cases */

class Solution {
    public double myPow(double x, int n) {
        // Handle base cases
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) { // 1 raised to any power is 1
            return 1.0;
        }
        if (x == -1.0) { // -1 raised to even power is 1, odd power is -1
            if (n % 2 == 0) {
                return 1.0;
            } else {
                return -1.0;
            }
        }


        // Handle negative exponent
        // Using long for 'N' to handle the edge case where n = Integer.MIN_VALUE.
        // If n is Integer.MIN_VALUE (-2^31), then -n would be 2^31, which exceeds Integer.MAX_VALUE (2^31 - 1).
        long N = n;
        if (N < 0) {
            x = 1 / x; // x becomes its reciprocal
            N = -N;    // N becomes positive
        }

        double result = 1.0;
        double currentX = x; // This will hold x, x^2, x^4, x^8, ...

        // Exponentiation by squaring (iterative approach)
        while (N > 0) {
            // If the current bit of N is 1 (i.e., N is odd)
            if (N % 2 == 1) {
                result *= currentX; // Multiply result by currentX
            }
            currentX *= currentX; // Square currentX for the next iteration
            N /= 2;               // Halve N (right shift)
        }

        return result;
    }
}