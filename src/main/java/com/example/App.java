package com.example;
class UtilityMethods {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public boolean isOdd(int num) {
        return num % 2 == 1;
    }

    // Utility method to return
    // sum of square of digit of n
    public int numSquareSum(int n) {
        int squareSum = 0;

        while (n != 0) {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }

        return squareSum;
    }

    public int power(int x, int y) {
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 0) {
            int temp = power(x, y / 2);
            return temp * temp;
        }

        int temp = power(x, y / 2);
        return x * temp * temp;
    }

    // Function to calculate number of digits in the number
    public int order(int x) {
        int n = 0;

        while (x != 0) {
            n = n + 1;
            x = x / 10;
        }

        return n;
    }

    public double customSqrt(double x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double guess = x / 2.0;

        while (true) {
            double newGuess = 0.5 * (guess + x / guess);

            if (Math.abs(newGuess - guess) < 1e-10) {
                return newGuess;
            }

            guess = newGuess;
        }
    }

    //  Utility function to check if
    // number is a perfect power or not
    public boolean isPower(int a) {
        if (a == 1) {
            return true;
        }

        for (int i = 2; i < a; i++) {
            double val = Math.log(a) / Math.log(i);
            if (Math.abs(val - (int) val) < 0.00000001) {
                return true;
            }
        }

        return false;
    }

}

public class App {
    static UtilityMethods util = new UtilityMethods();

    public static boolean isPrime(int num) {
        if (util.isEven(num) && num != 2) {
            return false;
        }

        if (num > 1) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPerfect(int num) {
        int sumDivisors = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sumDivisors += i;
            }
        }

        if (sumDivisors == num)
            return true;
        else
            return false;
    }

    // If a number is divisible by the sum of its digits, then it will be known as a
    // Harshad Number.
    public static boolean isHarshad(int num) {
        if (num == 0) {
            return false;
        }

        int remainder, totalSum = 0;
        int originalNum = num;

        while (num > 0) {
            remainder = num % 10;
            totalSum += remainder;
            num /= 10;
        }

        return originalNum % totalSum == 0;
    }

    // A number is called happy if it leads to 1 after a sequence of steps wherein
    // each step number
    // is replaced by the sum of squares of its digit that is if
    // we start with Happy Number and keep replacing it with digits square sum, we
    // reach 1.
    public static boolean isHappynumber(int num) {
        int slow = num;
        int fast = num;

        // Heavily Integration Testing as
        // it calls numSquareSum
        while (true) {
            slow = util.numSquareSum(slow);
            fast = util.numSquareSum(util.numSquareSum(fast));

            if (slow != fast) {
                continue;
            } else {
                break;
            }
        }

        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Triangular Numbers are those numbers which are obtained by continued
    // summation of the natural numbers 1, 2, 3, 4, 5,...
    public static boolean isTriangular(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        int triangularSum = 0;

        for (int i = 1; i <= num; i++) {
            triangularSum += i;

            if (triangularSum == num) {
                return true;
            }

            if (i == num) {
                return false;
            }
        }

        return false;
    }

    public static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num = num / 10;
        }

        if (originalNum == reversedNum) {
            return true;
        } else {
            return false;
        }
    }

    // Given a number x, determine whether the given number is Armstrong number or
    // not.
    // # A positive integer of n digits is called an Armstrong number of order n
    // (order is number of digits) if.
    // # abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ....
    public static boolean isArmstrong(int num) {
        // Heavily integration testing
        // calls power as well as order
        int digitCount = util.order(num);

        int temp = num;
        int sumOfPowers = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sumOfPowers += util.power(digit, digitCount);
            temp /= 10;
        }

        if (sumOfPowers == num) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }

        int left = 1, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // A number is said to be square-free if no prime factor divides it more than
    // once, i.e., the largest power of a prime factor that divides n is one.
    public static boolean isSquareFree(int num) {
        if (num % 2 == 0) {
            num = num / 2;
        }

        if (num % 2 == 0) {
            return false;
        }

        // Function for Integration Testing, since
        // it calls customSqrt
        for (int i = 3; i <= util.customSqrt(num); i++) {
            if (num % i == 0) {
                num = num / i;
            }

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Narcissistic Number is a number that is the sum of its own digits each raised
    // to the power of the number of digits
    public static boolean isNarcissistic(int num) {
        int numDigits = util.order(num);
        int originalNum = num;
        int totalSum = 0;

        while (originalNum != 0) {
            totalSum = totalSum + util.power(originalNum % 10, numDigits);
            originalNum = originalNum / 10;
        }

        if (num == totalSum) {
            return true;
        } else {
            return false;
        }
    }

    // A number n is said to be Powerful Number if for every prime factor p of it,
    // p2 also divides it
    public static boolean isPowerful(int n) {
        while (n % 2 == 0) {
            int power = 0;
            while (n % 2 == 0) {
                n /= 2;
                power += 1;
            }

            if (power == 1) {
                return false;
            }
        }

        int p = (int) util.customSqrt(n) + 1;
        for (int factor = 3; factor < p; factor += 2) {
            int power = 0;
            while (n % factor == 0) {
                n = n / factor;
                power += 1;
            }

            if (power == 1) {
                return false;
            }
        }

        return n == 1;
    }

    // An Achilles number is a number that is powerful
    // but not a perfect power
    public static boolean isAchillesNumber(int n) {
        if (isPowerful(n) && !util.isPower(n)) {
            return true;
        } else {
            return false;
        }
    }

    // Stirling Number of the second kind, S(n, k), is the number of ways of
    // splitting “n” items in “k” non-empty sets.
    // The formula used for calculating Stirling Number is:
    // S(n, k) = k* S(n-1, k) + S(n-1, k-1)
    public static int isStirling(int n, int k) {
        int originalN = n;
        int originalK = k;

        if (n <= 0) {
            return 1;
        } else if (k <= 0) {
            return 0;
        } else if (n == 0 && k == 0) {
            return -1;
        } else if (n != 0 && n == k) {
            return 1;
        } else if (n < k) {
            return 0;
        } else {
            int recursiveResult1 = isStirling(originalN - 1, originalK);
            return (originalK * recursiveResult1) + isStirling(originalN - 1, originalK - 1);
        }
    }

    // the Eulerian Number A(n, m),
    // is the number of permutations of the numbers 1 to n in which exactly m
    // elements are greater than previous element.
    public static int isEulerian(int n, int m) {
        if (m >= n || n == 0) {
            return 0;
        }

        if (m == 0) {
            return 1;
        }

        return ((n - m) * isEulerian(n - 1, m - 1) + (m + 1) * isEulerian(n - 1, m));
    }

    public static void main(String[] args) {
    }
}